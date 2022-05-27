package org.example;

import jade.gui.GuiEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ItemModel;

import java.io.IOException;

public class Validation {
    @FXML
    private Button annuler;

    @FXML
    private TextField showCategorie = new TextField();
    private String showCat;
    @FXML
    private TextField showMagasin= new TextField();
    private String showMag;
    @FXML
    private TextField showMarque= new TextField();
    private  String showMar;
    @FXML
    private TextField showPrixTotal= new TextField();
    private String showPrixT;
    @FXML
    private TextField showPrixUni= new TextField();
    private String showPrixU;
    @FXML
    private TextField showQuantity= new TextField();
    @FXML
    private Button valider;

    @FXML
    private Label reduction = new Label();

    @FXML
    public void onValidate(ActionEvent event) throws IOException {
        Item.newStage.close();
        String magasin = Item.magasin;
        GuiEvent guiEvent = new GuiEvent(this, 1);
        guiEvent.addParameter(magasin);
        MainContainer.acheteur.onGuiEvent(guiEvent);
        MainContainer.setRoot("affichageProduit");
    }

    @FXML
    public void onCancel(ActionEvent event) throws IOException {
        Item.newStage.close();
        MainContainer.setRoot("affichageProduit");
    }

    public void setDataValidated(ItemModel item) {

        this.showCategorie.setText(item.getCategorie());
        //System.out.println(showCategorie);
        this.showMagasin.setText(item.getNomMagasin());
        this.showMarque.setText(item.getNomMarque());
        this.showPrixUni.setText(String.valueOf(item.getPrix()));
        this.showQuantity.setText(String.valueOf(item.getQuantity()));
        int total = item.getPrix()*item.getQuantity();
        //System.out.println(quantityVoulu);
        if(item.getQuantity()>1){
            this.showPrixTotal.setText(String.valueOf(total-total*0.2));
            reduction.setVisible(true);
        }else{
            this.showPrixTotal.setText(String.valueOf(total));
        }
    }
}
