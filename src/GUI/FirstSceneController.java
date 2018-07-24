package GUI;

import static GUI.MainClass.mainStage;
import static GUI.MainClass.auto;
import automata.FilesHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FirstSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> autoList;
    @FXML
    private Label error;

    @FXML
    void SubmitClick(ActionEvent event) throws IOException {
        if (autoList.getValue() == null) {
            error.setText("ERROR : First Choose Automat!");
            return;
        } else {
            try {
                auto = FilesHandler.readFromFile("Automatas\\" + autoList.valueProperty().get() + ".JSON");
            } catch (Exception ex) {
                this.error.setText(ex.getMessage());
            }
            SecondSceneController.automatname = autoList.getValue();
            Pane mainPane = (Pane) FXMLLoader.load(MainClass.class.getResource("SecondScene.fxml"));
            mainStage.setScene(new Scene(mainPane));
            mainStage.show();
        }
        System.out.println("Automatas\\" + autoList.valueProperty().get() + ".JSON");
    }

    @FXML
    void initialize() {
        assert autoList != null : "fx:id=\"autoList\" was not injected: check your FXML file 'FirstScene.fxml'.";
        autoList.getItems().removeAll(autoList.getItems());
        File folder = new File("Automatas");
        File[] ListOfFiles = folder.listFiles();

        for (int i = 0; i < ListOfFiles.length; i++) {
            if (getFileExt(ListOfFiles[i]).equals("json")) {
                String s = ListOfFiles[i].getName();
                s = s.substring(0, s.indexOf("."));
                autoList.getItems().add(s);
            }
        }

    }

    private String getFileExt(File f) {
        String name = f.getName();
        if ((name.lastIndexOf(".") != -1) && (name.lastIndexOf(".") != 0)) {
            return name.substring(name.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
