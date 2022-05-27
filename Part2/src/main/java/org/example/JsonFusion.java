package org.example;
import org.json.JSONObject;


public class JsonFusion {

    public JSONObject getForm(){
        JSONObject form = new JSONObject();
        form.put("categorie", Categorie.categorie);

        switch (Categorie.categorie){
            case "pc":
                form.put("marque", Marque.marque);
                form.put("carte_graphique", CarteGraphique.carteGraphic);
                form.put("processeur", Processeur.processeur);
                form.put("disque_dur", Disc.disc);
                form.put("taille_ecran", TailleEcran.tailleEcran);
                form.put("ram", Ram.ram);
                break;
            case "ram":
                break;
            case "carte_graphic":
                break;
            case "disque_dur":
                break;
        }

        return form;
    }

    public  JSONObject getValidatedForm(){
        JSONObject form = new JSONObject();
        form.put("id", Item.item.getId());
        form.put("prix", Item.item.getPrix());
        form.put("magasin", Item.item.getNomMagasin());
        form.put("marque", Item.item.getNomMarque());
        form.put("categorie", Item.item.getCategorie());
        form.put("quantityVoulu", Item.item.getQuantity());

        return form;
    }

}
