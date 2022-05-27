package agents;



import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.example.AffichageProduit;
import org.example.Item;
import org.example.MainContainer;
import org.json.JSONArray;

import java.util.Arrays;

public class Acheteur extends GuiAgent {

    private MainContainer gui;
    @Override
    protected void setup() {
        gui=(MainContainer)getArguments()[0];

        gui.setAcheteur(this);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                MessageTemplate messageTemplate = MessageTemplate.or(
                        MessageTemplate.MatchPerformative(ACLMessage.REFUSE),
                        MessageTemplate.MatchPerformative(ACLMessage.PROPOSE));
                ACLMessage aclMessage=receive(messageTemplate);
                if(aclMessage!=null){
                    GuiEvent guiEvent = new GuiEvent(this, 1);
                    guiEvent.addParameter(aclMessage.getContent());
                    JSONArray jsonString = new JSONArray(aclMessage.getContent());
                    AffichageProduit.listOfProduct.add(jsonString);
                    //System.out.println(AffichageProduit.listOfProduct);
                    //gui.viewMessage(guiEvent);
                }else{
                    block();
                }
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("l'agent " + this.getAID().getName() + " se meurt ");
    }

    @Override
    public void onGuiEvent(GuiEvent guiEvent) {
        if(guiEvent.getType()==1){
            String content = guiEvent.getParameter(0).toString();
            diffuse_message(content);
        }
    }

    private void diffuse_message(String message_text){

        ACLMessage message = new ACLMessage(ACLMessage.CFP);

        // send to all services of type "Agency"
        DFAgentDescription t = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("vente");

        t.addServices(sd);
        try {
            DFAgentDescription[] R = DFService.search(this, t);
            DFAgentDescription dfAgentDesc;
            String localName;

            switch (message_text){
                case "magasin1":
                    message = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                    message.setContent("validation");
                    dfAgentDesc= R[0];
                    localName = dfAgentDesc.getName().getLocalName();
                    message.addReceiver(new AID(localName, AID.ISLOCALNAME));
                    break;
                case "magasin2":
                    message = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                    message.setContent("validation");
                    dfAgentDesc= R[1];
                    localName = dfAgentDesc.getName().getLocalName();
                    message.addReceiver(new AID(localName, AID.ISLOCALNAME));
                    break;
                case "magasin3":
                    message = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                    message.setContent("validation");
                    dfAgentDesc= R[2];
                    localName = dfAgentDesc.getName().getLocalName();
                    message.addReceiver(new AID(localName, AID.ISLOCALNAME));
                    break;
                default:
                    message.setContent("request");
                    for (DFAgentDescription dfAgentDescription : R) {
                        String local_name = dfAgentDescription.getName().getLocalName();
                        message.addReceiver(new AID(local_name, AID.ISLOCALNAME));
                    }
                    break;
            }

        } catch (FIPAException e) {
            e.printStackTrace();
        }
        this.send(message);

    }

}
