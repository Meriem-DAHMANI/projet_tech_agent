package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class Disc {

    @FXML
    private TextField discText= new TextField();
    @FXML
    static  String disc;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.discText = (TextField) event.getSource();
        disc = discText.getText().toLowerCase();
        MainContainer.setRoot("ram");
    }

}
