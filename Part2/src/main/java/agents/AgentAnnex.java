package agents;

import behaviours.MagasinBehaviour;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgentAnnex extends Agent {

    private String base_folder = System.getProperty("user.dir") + "\\src\\main\\java\\bases\\";
    private String categorie;
    protected void setup(){
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Magasin");
        sd.setName("Magasin");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException ex) {
            Logger.getLogger(AgentAnnex.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[] args = this.getArguments();
        String base_file_name = (String) args[0];
        JSONObject base = load_base(base_file_name);
        addBehaviour(new MagasinBehaviour(base));
    }

    private JSONObject load_base(String base_file_name){
        try {
            for(String file : Objects.requireNonNull(new File(base_folder).list())){
                Path path = Paths.get(base_folder + "//" + file);
                if(file.equals(base_file_name)){
                    String content = Files.readString(path, StandardCharsets.UTF_8);
                    return new JSONObject(content);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
