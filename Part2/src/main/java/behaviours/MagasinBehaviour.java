package behaviours;

import jade.core.AID;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import raisonneur.Raisonneur;
import raisonneur.ReturnedInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class MagasinBehaviour extends CyclicBehaviour {

    private JSONObject selected_base;
    public MagasinBehaviour(JSONObject selected_base) {
        this.selected_base = selected_base;
    }

    @Override
    public void action() {
        ACLMessage message = this.myAgent.blockingReceive();
        AID AID_sender = message.getSender();
        JSONObject content = new JSONObject(message.getContent());
        /*
        ArrayList<ReturnedInstance> result = Raisonneur.raisonner(selected_base,categorie, content);
        JSONArray j = Raisonneur.toJson(result);
        System.out.println(result);
        ACLMessage message_to_send = new ACLMessage(ACLMessage.INFORM);
        message_to_send.setContent(String.valueOf(j));
        message_to_send.addReceiver(new AID(AID_sender.getLocalName(), AID.ISLOCALNAME));
        getAgent().send(message_to_send);*/
    }

    // get the values from the json text we received
    private HashMap<String, String> get_values(JSONObject content){
        HashMap<String, String> values = new HashMap<>();
        for(String key : content.keySet()){
            values.put(key, content.getString(key));
        }
        return values;
    }
}
