package behaviours;

import org.json.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class MagasinManipulations {
    static String base_folder = System.getProperty("user.dir") + File.separator
            + "src"+ File.separator + "main" +  File.separator+"java"+
            File.separator + "bases" + File.separator + "Agent";

    public static String raisonner(JSONObject baseDeFaits, JSONObject facts){
        return null;
    }

    private static ArrayList<JSONObject> returnFileAgencies(){
        ArrayList<JSONObject> files_content = new ArrayList<>();
        try {
            for(String file : Objects.requireNonNull(new File(base_folder).list())){
                Path path = Paths.get(base_folder + File.separator + file);
                String content = Files.readString(path, StandardCharsets.UTF_8);
                JSONObject jsonObject = new JSONObject(content);
                files_content.add(jsonObject);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return files_content;
    }
}
