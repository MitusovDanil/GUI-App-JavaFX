module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens org.example.controller to javafx.fxml;
    exports org.example;
    exports org.example.entity;
}