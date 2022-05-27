package org.example;

import agents.Acheteur;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MainContainer extends Application{
    static Acheteur acheteur;
    private String base_folder = System.getProperty("user.dir") + "/src/main/java/bases";
    private static Scene scene;
    public static void main(String[] args) {
        launch(MainContainer.class);
    }

    public void startContainer(){
        try{
            Runtime runtime = Runtime.instance();
            Properties properties = new ExtendedProperties();
            properties.setProperty(Profile.GUI, "true");
            Profile profile = new ProfileImpl(properties);
            AgentContainer mainContainer = runtime.createMainContainer(profile);
            AgentController mainController1= mainContainer.createNewAgent(
                    "acheteur", "agents.Acheteur",new Object[]{this});
            mainController1.start();
            AgentController mainController2= mainContainer.createNewAgent(
                    "vendeur1", "agents.Vendeur",new Object[]{this, load_base("Agent1.json")});
            mainController2.start();
            AgentController mainController3= mainContainer.createNewAgent(
                    "vendeur2", "agents.Vendeur",new Object[]{this, load_base("Agent2.json")});
            mainController3.start();
            AgentController mainController4= mainContainer.createNewAgent(
                    "vendeur3", "agents.Vendeur",new Object[]{this, load_base("Agent3.json")});
            mainController4.start();
        }catch (ControllerException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        startContainer();
        scene = new Scene(loadFXML("ram"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainContainer.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void setAcheteur(Acheteur acheteur) {this.acheteur = acheteur;}


    private JSONObject load_base(String base_file_name) throws IOException {
        File directory = new File(base_folder);
        System.out.println( directory);
        String[] flist = directory.list();
        if (flist == null) {
            System.out.println("Empty directory.");
        }
        else {
            // Linear search in the array
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.equalsIgnoreCase(base_file_name)) {
                    Path path = Paths.get(base_folder + "//" + base_file_name);
                    String content = Files.readString(path, StandardCharsets.UTF_8);
                    System.out.println(filename + " found");
                    return new JSONObject(content);
                }
            }
        }
        return null;
    }
}

