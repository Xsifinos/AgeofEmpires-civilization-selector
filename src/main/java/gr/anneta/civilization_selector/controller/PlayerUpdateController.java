package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.service.PlayerService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 *
 * @author chsifinos@gmail.com
 */
public class PlayerUpdateController implements Initializable {

    private String username;
    @FXML
    private TextField playerUsername;
    @FXML
    private TextField playerName;

    @FXML
    void editPlayer(ActionEvent event) {
//        playerUsername.getText();
//        player.setName(name.getText());
//        PlayerService playerService = new PlayerService();
//        try {
//            playerService.update(player);
//            Stage stage = (Stage) close.getScene().getWindow();
//            stage.close();
//        } catch (SifinosException ex) {
//            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
//            alert.showAndWait();
//        }
//        username.setCellValueFactory(
//                new PropertyValueFactory<Player, String>("Name"));
//        username.setCellFactory(TextFieldTableCell.forTableColumn());
//        username.setOnEditCommit(
//                new EventHandler<CellEditEvent<Player, String>>() {
//            @Override
//            public void handle(CellEditEvent<User, String> t) {
//                ((User) t.getTableView().getItems().get(
//                        t.getTablePosition().getRow())).setName(t.getNewValue());
//            }
//        }
//        );
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = getStage();
        stage.close();
    }

    @FXML
    private Stage getStage() {
        Stage stage = (Stage) playerName.getScene().getWindow();
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
