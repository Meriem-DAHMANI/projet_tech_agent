module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires jade;
    requires json.java;
    requires com.google.gson;


    opens org.example to javafx.fxml;
    exports org.example;
    exports agents;
}
