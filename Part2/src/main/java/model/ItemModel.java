package model;

public class ItemModel {

    private String nomMagasin;
    private String nomMarque;
    private  String imgCat;
    private int prix;
    private int quantity;
    private String categorie;
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public void setImgCat(String imgCat) {
        this.imgCat = imgCat;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNomMagasin() {
        return nomMagasin;
    }

    public String getImgCat() {
        return imgCat;
    }

    public int getPrix() {
        return prix;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNomMarque() {
        return nomMarque;
    }
}
