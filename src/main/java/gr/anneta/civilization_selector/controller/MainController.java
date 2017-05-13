package gr.anneta.civilization_selector.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private CheckBox allowDuplicate;

    @FXML
    void allowDuplicate(ActionEvent event) throws IOException {
    }

    @FXML
    void managePlayers(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Age of Empires Civilization Selector - Players");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerManagerView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void manageCivilizations(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Age of Empires Civilization Selector - Civilizations");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CivilizationManagerView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void showUsernamesWithCivilizations(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        stage.setTitle("Age of Empires Civilization Selector - Main");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayersView.fxml"));
//        Parent root = (Parent) loader.load();
//        stage.setScene(new Scene(root));
//        stage.show();
    }

    @FXML
    void klisimoAction(ActionEvent event) {
        Stage stage = getStage();
        stage.close();
    }

    @FXML
    private Stage getStage() {
        Stage stage = (Stage) allowDuplicate.getScene().getWindow();
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
