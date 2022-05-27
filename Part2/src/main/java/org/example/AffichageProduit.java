package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import model.ItemModel;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AffichageProduit implements Initializable {


    public static ArrayList<JSONArray> listOfProduct = new ArrayList<>();
    public static int quantity;
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    private Image image;
    private MyListener myListener;


    private List<ItemModel> getDta(){

        List<ItemModel>  itemModelList = new ArrayList<>();
        ItemModel itemModel;

        for(int i=0;i<listOfProduct.size();i++){
            itemModel = new ItemModel();
            JSONArray json = listOfProduct.get(i);
            for(int j=0;j<json.length();j++){
                itemModel.setNomMarque(json.getJSONObject(j).getString("marque"));
                itemModel.setNomMagasin(json.getJSONObject(j).getString("shop_name"));
                itemModel.setPrix(json.getJSONObject(j).getInt("prix"));
                itemModel.setQuantity(json.getJSONObject(j).getInt("nombreDisponible"));
                itemModel.setCategorie(json.getJSONObject(j).getString("categorie"));
                itemModel.setId(json.getJSONObject(j).getInt("id"));
                itemModelList.add(itemModel);
            }
        }
        return itemModelList;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<ItemModel> itemModelList = getDta();
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < itemModelList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                Item itemController = fxmlLoader.getController();
                itemController.setData(itemModelList.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

