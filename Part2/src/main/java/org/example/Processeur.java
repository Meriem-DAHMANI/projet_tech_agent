package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class Processeur {

    @FXML
    private TextField processeurText= new TextField();
    @FXML
    static String processeur;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.processeurText = (TextField) event.getSource();
        processeur = processeurText.getText().toLowerCase();
        MainContainer.setRoot("disc");
    }
}
