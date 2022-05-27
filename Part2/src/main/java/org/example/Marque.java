package org.example;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Marque {


    @FXML
    private TextField marqueText= new TextField();
    @FXML
    static String marque;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.marqueText = (TextField) event.getSource();
        marque = marqueText.getText().toLowerCase();
        System.out.println("je suis le tout  "+marqueText.getText().toLowerCase());
        String categorie = Categorie.categorie;
        switch (categorie) {
            case "pc":
                MainContainer.setRoot("carteGraphic");
                break;
            case "ram":
                MainContainer.setRoot("taille");
                break;
            case "disque_dur":
                MainContainer.setRoot("taille");
                break;
            case "carte_graphique":
                MainContainer.setRoot("type");
                break;
        }
    }

}
