package org.example;

import jade.gui.GuiEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;


public class Ram {

    @FXML
    private TextField ramText= new TextField();
    static String ram;
    @FXML
    private void onEnter(ActionEvent event) throws IOException {
        this.ramText = (TextField) event.getSource();
        ram=ramText.getText().toLowerCase();
        GuiEvent guiEvent = new GuiEvent(this, 1);
        guiEvent.addParameter("request");
        MainContainer.acheteur.onGuiEvent(guiEvent);
        MainContainer.setRoot("affichageProduit");
    }
}
