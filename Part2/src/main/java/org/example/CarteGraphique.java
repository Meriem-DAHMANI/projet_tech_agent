package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;


public class CarteGraphique {

    @FXML
    private TextField carteGraphicText = new TextField();
    @FXML
    static  String carteGraphic;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.carteGraphicText = (TextField) event.getSource();
        this.carteGraphic = carteGraphicText.getText().toLowerCase();
        MainContainer.setRoot("tailleEcran");
    }
}
