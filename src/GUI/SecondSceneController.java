package GUI;

import static GUI.MainClass.mainStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static GUI.MainClass.auto;

public class SecondSceneController {

    public static String automatname;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField word;

    @FXML
    private Label result;
    @FXML
    private Label category;
    @FXML
    private Label autoname;

    @FXML
    void gobackclick(ActionEvent event) throws IOException {
        Pane mainPane = (Pane) FXMLLoader.load(MainClass.class.getResource("FirstScene.fxml"));
        mainStage.setScene(new Scene(mainPane));
        mainStage.show();
    }

    @FXML
    void matchclick(ActionEvent event) {
        try{
            this.result.setStyle("-fx-text-fill: #e0e0e0;");
            this.result.setText(new Boolean(auto.match(word.getText()).match).toString());
            this.category.setText(auto.match(word.getText()).category);
        }catch(Exception ex){
            this.category.setText("");
            this.result.setStyle("-fx-text-fill: red;");
            this.result.setText(ex.getMessage());
        }
        
    }

    @FXML
    void initialize() {
        assert word != null : "fx:id=\"word\" was not injected: check your FXML file 'SecondScene.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'SecondScene.fxml'.";
        autoname.setText("Automata Name : " + automatname);
    }
}
