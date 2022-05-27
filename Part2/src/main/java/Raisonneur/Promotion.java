package Raisonneur;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Promotion {

    public static int promoPrix(int prixVente, int quantityVente, int quantityVoulu){
        int prix = prixVente;
        int quantity  = quantityVente;
        if(quantityVente>= quantityVoulu && quantityVoulu>1){
            prix = prix*quantityVoulu-(int)(prix*quantityVoulu*0.1);
           return prix;
        }else{
            if(quantityVente< quantityVoulu || quantityVente==0){
                System.out.println("hors stock");
                return 0;
            }else{
                if(quantityVoulu==1){
                    return prix;
                }
            }
        }
        return prix;
    }

    public static int quantityCheck( int quantityVente, int quantityVoulu){
        int quantity  = 0;
        if(quantityVente>= quantityVoulu){
            quantity=quantityVente-quantityVoulu;
            return quantity;
        }else{
            if(quantityVente< quantityVoulu || quantityVente==0){
                System.out.println("hors stock");
                return 0;
            }
        }
        return 0;
    }

    public static void promoAnuelle(JSONObject jsonVente){
        int prix = jsonVente.getInt("prix");
        System.out.println("Venez voir les promotions de la saison");
        List<String> givenList = Arrays.asList("ete", "hiver", "printmps", "automn");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        switch (randomElement){
            case "hiver":
                prix = (int)(prix-prix*0.2);
            case "printmps":
                prix = (int)(prix-prix*0.1);
            case "automn":
                prix = (int)(prix-prix*0.3);
        }
        jsonVente.put("prix", prix);
    }

}
