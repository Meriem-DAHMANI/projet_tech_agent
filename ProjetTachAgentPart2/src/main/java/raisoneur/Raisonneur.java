package raisoneur;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;


public class Raisonneur {

    /**
     *
     * @param magasinInformation un fichier json contenant toutes les information du magasin
     * @param categorie l'achat un pc, une carte graphique, ram ou un disque dur
     * @param facts les entrées du client
     * @return une liste d'achats
     */
    public static ArrayList<ReturnedInstance> raisonner(JSONObject magasinInformation,
                                                        String categorie,
                                                        JSONObject facts){
        JSONArray features;
        JSONArray ventes = magasinInformation.getJSONArray("ventes");
        ArrayList<ReturnedInstance> returnVentes = new ArrayList<>();
        ArrayList<JSONObject> listVentes= new ArrayList<>();

        // Pour chaque catégorie on vérifie les achats
        switch (categorie){
            case "pc":
                features = ventes.getJSONObject(0).getJSONArray("features_pc");
                for(int i=0; i<features.length();i++){
                    JSONObject jsonVente = features.getJSONObject(i);
                    if (checkValidityPc(jsonVente, facts)){
                        listVentes.add(jsonVente);
                    }
                }
                break;
            case "carte_graphic":
                features = ventes.getJSONObject(1).getJSONArray("features_carte_graphic");
                for(int i=0; i<features.length();i++){
                    JSONObject jsonVente = features.getJSONObject(i);
                    if (checkValidityCarteGraphic(jsonVente, facts)){
                        listVentes.add(jsonVente);
                    }
                }
                break;
            case "ram":
                features = ventes.getJSONObject(2).getJSONArray("features_ram");
                for(int i=0; i<features.length();i++){
                    JSONObject jsonVente = features.getJSONObject(i);
                    if (checkValidityRam(jsonVente, facts)){
                        listVentes.add(jsonVente);
                    }
                }
                break;
            case "disque_dur":
                features = ventes.getJSONObject(3).getJSONArray("features_disc");
                for(int i=0; i<features.length();i++){
                    JSONObject jsonVente = features.getJSONObject(i);
                    if (checkValidityDisc(jsonVente, facts)){
                        listVentes.add(jsonVente);
                    }
                }
                break;
        }
        for (JSONObject vente : listVentes){
            returnVentes.add(new ReturnedInstance(magasinInformation.getString("shop_name"), categorie,vente));
        }
        return returnVentes;
    }

    /**
     * Toutes les fonctions de checkBalidity ont pour but de comparer les element des deux fichiers json
     * @param jsonVente un fichier json contenant les produit
     * @param facts un fichier json contenat le produit qu'on vut acheter
     * @return
     */
    private static boolean checkValidityPc(JSONObject jsonVente, JSONObject facts) {
        String marque = jsonVente.getString("marque");
        String carte_graphique = jsonVente.getString("carte_graphique");
        int taille_ecran = jsonVente.getInt("taille_ecran");
        String processeur = jsonVente.getString("processeur");
        String disque_dur = jsonVente.getString("disque_dur");
        int ram = jsonVente.getInt("ram");
        int quantity= jsonVente.getInt("quantity");

        return marque.equals(facts.getString("marque"))
                && carte_graphique.equals(facts.getString("carte_graphique"))
                && taille_ecran== facts.getInt("taille_ecran")
                && processeur.equals(facts.getString("processeur"))
                && disque_dur.equals(facts.getString("disque_dur"))
                && ram==facts.getInt("ram")
                && (quantity >= facts.getInt("quantity"));
    }

    private static boolean checkValidityRam(JSONObject jsonVente, JSONObject facts) {
        int taille = jsonVente.getInt("taille");
        return taille== facts.getInt("taille");
    }
    private static boolean checkValidityCarteGraphic(JSONObject jsonVente, JSONObject facts) {
        String marque = jsonVente.getString("marque");
        ArrayList<String> utilisations = new ArrayList<>();
        for (int i=0; i<jsonVente.getJSONArray("utilisation").length(); i++){
            utilisations.add( (String) jsonVente.getJSONArray("utilisation").get(i));
        }
        boolean usage = false;
        int i=0;
        while (i<utilisations.size() && usage == false){
            if(facts.getString("utilisation").equals(utilisations.get(i))) {
                usage = true;
                i++;
            }
        }
        return usage && marque.equals(facts.getString("marque"));
    }
    
    private static boolean checkValidityDisc(JSONObject jsonVente, JSONObject facts) {
        String marque = jsonVente.getString("marque");
        String type = jsonVente.getString("type");
        int taille = jsonVente.getInt("taille");
        
        return marque.equals(facts.getString("marque"))
                && type.equals(facts.getString("type"))
                && taille == jsonVente.getInt("taille");
    }


    public static JSONArray toJson(ArrayList<ReturnedInstance> returnedInstances){
        JSONArray jarray = new JSONArray();
        for (ReturnedInstance returnedInstance: returnedInstances){
            jarray.put(returnedInstance.toJson());
        }
        return jarray;
    }

}
