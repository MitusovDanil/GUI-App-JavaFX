package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String USER = "minus";
    public static final String PASSWORD = "AppForNauka$315920";
    public static final String SELECT_DEP = "select * from time_sheet.departments";
    public static final String SELECT_WORKERS = "select * from time_sheet.workers where dep_id = ";
    public static final String SELECT_DAY = "select date from time_sheet.calendar where year(date)=2020 and month(date)= ";
    public static final String SELECT_MARKS =  "SELECT marks FROM time_sheet.calendar LEFT JOIN time_sheet.marks USING(mark_id) where work_id = ";


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("test"));
        stage.setScene(scene);
        stage.show();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Выбрать департамент");
        a.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}