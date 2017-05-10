package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Player;
import gr.softaware.lib.javafx.exception.SifinosException;
import gr.anneta.civilization_selector.service.PlayerService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author chsifinos@gmail.com
 */
public class PlayerUpdateController implements Initializable {

    private final PlayerService PLAYER_SERVICE = new PlayerService();
//    private String username;
    @FXML
    private Label title;
//    @FXML
//    private GridPane grid; 
    @FXML
    protected TextField playerUsername;
    @FXML
    protected TextField playerName;
    private Player player;

    @FXML
    void editPlayer(ActionEvent event) {

//        Player player = new Player();
//        Player player = (Player) PlayerManagerController.tableManager.getTable().getSelectionModel().getSelectedItem();
//        player.setUsername(username);
        
            player.setName(playerName.getText());
//        player.setUsername(playerUsername.getText());
//        playerName.setText(player.getName());
            try {

//            Player player1 = (Player) PlayerManagerController.tableManager.getTable().getSelectionModel().getSelectedItem();
                Player player1 = PLAYER_SERVICE.update(player);
//            PlayerManagerController.tableManager.clearObjects(PLAYER_SERVICE.find());
//            PlayerManagerController.tableManager.addObjects(PLAYER_SERVICE.find());
                PlayerManagerController.tableManager.updateObject(player1);
                getStage().close();
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
            } catch (SifinosException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.setResizable(true);
                alert.getDialogPane().setPrefWidth(450);
                alert.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private Stage getStage() {
        return (Stage) title.getScene().getWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        grid = new GridPane();
//        playerUsername=new TextField();
//        playerName=new TextField();
//        grid.getChildren().add(playerUsername);
//        grid.getChildren().add(playerName);
//        title=new Label();
        player = PlayerManagerController.tableManager.getSelectedObject();
//        username=player.getUsername();
//        String name=player.getName();

//        username = (String) col.getCellObservableValue(username).getValue();
//        playerUsername.textProperty().set(username);
//        playerName.setVisible(true);//appendText(name); //setText(name);
            playerUsername.setText(player.getUsername());
            playerName.setText(player.getName());
    }
//    @Override
//    public String toString() {
//        // Convert the user object to string name and username.
//        return this.username;
//    }
}
