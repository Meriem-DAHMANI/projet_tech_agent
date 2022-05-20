package raisoneur;

import org.json.JSONObject;

import java.util.*;

/**
 * Cette class vise à manipuler notre fichier json et créer une instance.
 */
public class ReturnedInstance {

    private String magasin;
    private JSONObject features;
    private String categorie;
    private String marque;
    private String carte_graphique;
    private String processeur;
    private String disque_dur;
    private String type;
    private ArrayList<String> utilisation;
    private int taille;
    private int taille_ecran;
    private int ram;
    private int prix;
    private int quantity;


    /**
     *
     * @param magasin nom du magasin
     * @param categorie l'achat un pc, une carte graphique, ram ou un disque dur
     * @param features caractéristiques de chaque categorie qu'on obtient à partir de json
     */
    public ReturnedInstance(String magasin, String categorie, JSONObject features) {
        this.magasin = magasin;
        this.categorie = categorie;
        switch (categorie) {
            case "pc":
                this.marque = features.getString("marque");
                this.carte_graphique = features.getString("carte_graphique");
                this.processeur = features.getString("processeur");
                this.disque_dur = features.getString("disque_dur");
                this.taille_ecran = features.getInt("taille_ecran");
                this.ram = features.getInt("ram");
                this.prix = features.getInt("prix");
                this.quantity = features.getInt("quantity");
                break;
            case "ram":
                this.taille = features.getInt("taille");
                this.marque=features.getString("marque");
                break;
            case "carte_graphique":
                this.marque = features.getString("marque");
                for (int i = 0; i < features.getJSONArray("utilisation").length(); i++) {
                    this.utilisation.add((String) features.getJSONArray("utilisation").get(i));
                }
                break;
            case "disque_dur":
                this.marque = features.getString("marque");
                this.type = features.getString("type");
                this.taille = features.getInt("taille");
                break;
        }
    }

    /**
     * Une fonction qui convertit notre résultat en un fichier json
     * @return
     */
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("shop_name", this.magasin);
        json.put("price", this.prix);
        json.put("categorie", this.categorie);
        json.put("marque", this.marque);
        return json;
    }
}

