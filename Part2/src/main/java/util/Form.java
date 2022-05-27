package util;

public class Form {

    private String categorie;
    private String marque;
    private String carteGraphic;
    static private String processeur;
    private String disc;
    private String type;
    private int taille;
    private int tailleEcran;
    private int ram;
    private int quantity;


    public String getCategorie() {return categorie;}
    public String getMarque() {return marque;}
    public String getCarteGraphic() {return carteGraphic;}
    public String getProcesseur() {return processeur;}
    public String getDisc() {return disc;}
    public String getType() {return type;}
    public int getTaille() {return taille;}
    public int getTailleEcran() {return tailleEcran;}
    public int getRam() {return ram;}
    public int getQuantity() {return quantity;}

    public void setCategorie(String categorie) {this.categorie = categorie;}
    public void setMarque(String marque) {this.marque = marque;}
    public void setCarteGraphic(String carteGraphic) {this.carteGraphic = carteGraphic;}
    public void setProcesseur(String processeur) {this.processeur = processeur;}
    public void setDisc(String disc) {this.disc = disc;}
    public void setType(String type) {this.type = type;}
    public void setTaille(int taille) {this.taille = taille;}
    public void setTailleEcran(int tailleEcran) {this.tailleEcran = tailleEcran;}
    public void setRam(int ram) {this.ram = ram;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
}
