package org.example;

import jade.gui.GuiEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ItemModel;

import java.io.IOException;


public class Item {

    @FXML
    private Button acheter;

    @FXML
    private Label magasinLabel;

    @FXML
    private Label marqueLabel;

    @FXML
    private Label prixLbel;

    @FXML
    private TextField quantity;

    @FXML
    private Label quantityHiding;

    @FXML
    private Label catHiding;

    @FXML
    private Label idHiding;

    static ItemModel item;
    static int nbrProduit;
    static int prix;
    static String categorie;
    static String marque;
    static int quantityVoulu;
    static String magasin;
    static  int id;
    static  Stage newStage;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {

        this.quantityVoulu= Integer.parseInt(quantity.getText().toLowerCase());
        magasin = magasinLabel.getText();
        nbrProduit = Integer.parseInt(quantityHiding.getText());
        marque = marqueLabel.getText();
        prix = Integer.parseInt(prixLbel.getText());
        categorie = catHiding.getText();
        id= Integer.parseInt(idHiding.getText());

        if(quantityVoulu>nbrProduit){
            System.out.println("Quantité hors stock");
            this.quantity.setText(String.valueOf(nbrProduit));
        }else{
            System.out.println("Everything cool");

            this.item = new ItemModel();
            item.setCategorie(categorie);
            item.setQuantity(quantityVoulu);
            item.setNomMarque(marque);
            item.setNomMagasin(magasin);
            item.setPrix(prix);
            item.setId(id);
            /*// Step 2
            Node node = (Node) event.getSource();
            // Step 3
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();*/
            // Step 4
            FXMLLoader loader = new FXMLLoader(getClass().getResource("validation.fxml"));
            Parent root = (Parent) loader.load();
            Validation validationController = loader.getController();
            validationController.setDataValidated(item);
            Scene newScene = new Scene(root);
            this.newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();

            // Step 5
               /* stage.setUserData(item);
                // Step 6
                Scene scene = new Scene(root);
                stage.setScene(scene);
                // Step 7
                stage.show();*/
        }

    }

    public void setData(ItemModel item) {
        magasinLabel.setText(item.getNomMagasin());
        marqueLabel.setText(item.getNomMarque());
        prixLbel.setText(String.valueOf(item.getPrix()));
        quantityHiding.setText(String.valueOf(item.getQuantity()));
        quantity.setText(String.valueOf(item.getQuantity()));
        catHiding.setText(item.getCategorie());
        idHiding.setText(String.valueOf(item.getId()));
    }
}
