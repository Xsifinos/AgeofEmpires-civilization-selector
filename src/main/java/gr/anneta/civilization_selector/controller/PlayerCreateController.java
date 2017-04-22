package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.lib.SifinosException;
import gr.anneta.civilization_selector.service.PlayerService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chsifinos@gmail.com
 */
public class PlayerCreateController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField username;

    @FXML
    void create(ActionEvent event) {
        Player player = new Player();
        player.setUsername(username.getText());
        player.setName(name.getText());
        PlayerService playerService = new PlayerService();
        try {
            playerService.create(player);
            Stage stage = getStage();
            stage.close();
        } catch (SifinosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = getStage();
        stage.close();
    }

    @FXML
    private Stage getStage(){
        Stage stage = (Stage) name.getScene().getWindow();
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
