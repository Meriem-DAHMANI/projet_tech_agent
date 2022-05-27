package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Categorie implements Initializable {


    static String categorie;
    
    @FXML
    private String onEnter(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        switch (btn.getId()) {
            case "btnPC":
                this.categorie="pc";
                break;
            case "btnRAM":
                this.categorie="ram";
                break;
            case "btnDisc":
                this.categorie="disque_dur";
                break;
            case "btnCarteGraphic":
                this.categorie="carte_graphique";
                break;
        }
        MainContainer.setRoot("marque");
        return categorie;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
