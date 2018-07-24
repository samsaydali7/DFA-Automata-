/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import automata.Automata;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Fares Awa
 */
public class MainClass extends Application {

    public static Stage mainStage;
    public static Automata auto;

    public static void mainn(String[] args) //this is main
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Pane mainpane = (Pane) FXMLLoader.load(MainClass.class.getResource("FirstScene.fxml"));
        primaryStage.setScene(new Scene(mainpane));
        primaryStage.setTitle("Automata");
        primaryStage.show();

    }
}
