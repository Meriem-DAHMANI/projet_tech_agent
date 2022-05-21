package raisonneur;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String content = Files.readString(Paths.get("src" +
                File.separator + "main" +File.separator + "java"+
                File.separator+ "bases" + File.separator + "Agent1.json"), StandardCharsets.UTF_8);

        JSONObject jsonObject = new JSONObject(content);
        JSONObject facts = new JSONObject();


        facts.put("marque", "asus");
        facts.put("carte_graphique", "nvidia");
        facts.put("taille_ecran",15);
        facts.put("processeur", "i7");
        facts.put("disque_dur", "ssd");
        facts.put("ram", 16);
        facts.put("quantity", 1);

        ArrayList<ReturnedInstance> rt = Raisonneur.raisonner(jsonObject,"pc",  facts);
        JSONArray j = Raisonneur.toJson(rt);
        System.out.println(String.valueOf(j));

    }
}
