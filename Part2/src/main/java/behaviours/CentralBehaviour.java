package behaviours;


import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import org.json.JSONArray;


public class CentralBehaviour extends CyclicBehaviour {
    public CentralBehaviour() {

    }

    @Override
    public void action() {

        ACLMessage message = this.myAgent.receive();
        if(message != null) {
            // AID AID_sender = message.getSender();
            JSONArray jsonArray = new JSONArray(message.getContent());
        }
    }
}
