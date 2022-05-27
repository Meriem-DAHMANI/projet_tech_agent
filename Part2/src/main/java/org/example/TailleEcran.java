package org.example;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class TailleEcran {

    @FXML
    private TextField tailleEcranText= new TextField();
    static  String tailleEcran;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.tailleEcranText = (TextField) event.getSource();
        tailleEcran = tailleEcranText.getText().toLowerCase();
        MainContainer.setRoot("processeur");
    }
}

