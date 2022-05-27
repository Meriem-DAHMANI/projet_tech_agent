package agents;

import com.google.gson.Gson;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import org.example.Item;
import org.example.JsonFusion;
import org.json.JSONArray;
import org.json.JSONObject;
import Raisonneur.*;

import java.util.ArrayList;

public class Vendeur extends  Agent{

    JsonFusion jsonFusion = new JsonFusion();
    protected void setup() {
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);
        parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                DFAgentDescription dfAgentDescription = new DFAgentDescription();
                dfAgentDescription.setName(getAID());
                ServiceDescription serviceDescription = new ServiceDescription();
                serviceDescription.setType("vente");
                serviceDescription.setName("vente");
                dfAgentDescription.addServices(serviceDescription);
                try {
                    DFService.register(myAgent, dfAgentDescription);
                } catch (FIPAException e) {
                    e.printStackTrace();
                }
            }
        });
        parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = this.myAgent.blockingReceive();
                AID AID_sender = message.getSender();
                JSONObject facts = new JSONObject();
                String result;
                ACLMessage message_to_send;
                switch (message.getContent()){
                    case "request":
                        //JSONObject content = new JSONObject(message.getContent());
                        //JSONObject facts = jsonFusion.getForm();
                        facts.put("categorie", "pc");
                        facts.put("marque", "asus");
                        facts.put("carte_graphique", "nvidia");
                        facts.put("taille_ecran",15);
                        facts.put("processeur", "i7");
                        facts.put("disque_dur", "ssd");
                        facts.put("ram", 16);
                        facts.put("quantity", 5);

                        result = raisonner((JSONObject) getArguments()[1], facts);
                        message_to_send = new ACLMessage(ACLMessage.PROPOSE);
                        message_to_send.setContent(result);
                        message_to_send.addReceiver(new AID(AID_sender.getLocalName(), AID.ISLOCALNAME));
                        getAgent().send(message_to_send);
                        break;
                    case "validation":
                        facts = jsonFusion.getValidatedForm();
                        result = Raisonneur.updateData(facts, (JSONObject) getArguments()[1]);

                        message_to_send = new ACLMessage(ACLMessage.CONFIRM);
                        message_to_send.setContent(result);
                        message_to_send.addReceiver(new AID(AID_sender.getLocalName(), AID.ISLOCALNAME));
                        getAgent().send(message_to_send);
                        break;
                }


            }
        });
    }

    public static String raisonner(JSONObject baseDeFaits, JSONObject facts){

        ArrayList<ReturnedInstance> returned_instances = Raisonneur.raisonner(baseDeFaits, facts.getString("categorie"), facts);
        JSONArray jarray = Raisonneur.toJsonProduct(returned_instances);
        return jarray.toString();
    }

    public String offrePromo(JSONObject jsonVente){
        Promotion.promoAnuelle(jsonVente);
        return  jsonVente.toString();
    }
}
