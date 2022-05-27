package Raisonneur;

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
    private int id;


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
                this.id = features.getInt("id");
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
                this.id = features.getInt("id");
                this.taille = features.getInt("taille");
                this.marque=features.getString("marque");
                break;
            case "carte_graphique":
                this.id = features.getInt("id");
                this.marque = features.getString("marque");
                for (int i = 0; i < features.getJSONArray("utilisation").length(); i++) {
                    this.utilisation.add((String) features.getJSONArray("utilisation").get(i));
                }
                break;
            case "disque_dur":
                this.id = features.getInt("id");
                this.marque = features.getString("marque");
                this.type = features.getString("type");
                this.taille = features.getInt("taille");
                break;
        }
    }

    public int getPrix() {return prix;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setPrix(int prix) {this.prix = prix;}

    /**
     * Une fonction qui convertit notre résultat en un fichier json
     * @return
     */
    public  JSONObject toJsonProduct() {
        //int quantityBeforeBuying = this.quantity;
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("shop_name", this.magasin);
        json.put("marque", this.marque);
        json.put("prix", this.prix);
        json.put("nombreDisponible" ,this.quantity);
        json.put("categorie", this.categorie);
        /*this.quantity=quantity;
        json.put("nombre de truc achete:" ,quantityBeforeBuying-quantity);*/
        /*this.prix = prix;
        json.put("price totale: ", this.prix);
        */

        return json;
    }
}

