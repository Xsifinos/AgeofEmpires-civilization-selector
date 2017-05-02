package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.lib.TableManager;
import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.lib.SifinosException;
import gr.anneta.civilization_selector.service.PlayerService;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PlayerManagerController implements Initializable {

    protected static TableManager<Player> tableManager;
    private final PlayerService PLAYER_SERVICE = new PlayerService();

    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn nameCol;
//    private  String username;

    @FXML
    void create(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Age of Empires Civilization Selector - Create Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerCreateView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Age of Empires Civilization Selector - Edit Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerUpdateView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        Player player = tableManager.getSelectedObject();
        if (player == null) {
            Alert alertNullPointer = new Alert(Alert.AlertType.ERROR, "Δεν έχετε επιλέξει κανέναν παίκτη!!");;;;
            alertNullPointer.initModality(Modality.APPLICATION_MODAL);
            alertNullPointer.setResizable(true);
            alertNullPointer.getDialogPane().setPrefWidth(300);
            alertNullPointer.showAndWait();
        } else {
            String username = player.getUsername();
//        Player player = new Player();
//        String username = null;
//        usernameCol.getCellValueFactory();
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("ΔΙΑΓΡΑΦΗ ΠΑΙΚΤΗ");
            alert.setHeaderText(null);
//        Graphics graphic;  // You can't create new object Graphics because of abstract.
//        Image image1 = new Image("/files/images/1492875257_alert");
            ImageView imageView = new ImageView(getClass().getResource("/files/images/1492875257_alert.png").toExternalForm());
//                new ImageView(new Image(getClass().getResourceAsStream("/files/images/1492875257_alert.png")));
            alert.setGraphic(imageView);
            alert.initModality(Modality.APPLICATION_MODAL);
//        alert.getDialogPane().setPrefWidth(550);
            alert.setResizable(true);
//        alert.setContentText("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username?");
//        alert.getDialogPane().setPrefSize(800,100);  // Not a recommended solution for different projects.
            Label label = new Label("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username " + "'" + username + "'" + "?");
//        Text text=new Text("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username " + "'" + username + "'" + " ?");
            label.setWrapText(true);
//        text.setWrappingWidth(500);  // If i want to wrap in different lines using Text.
            alert.getDialogPane().setContent(label);

            ButtonType okButton = new ButtonType("Ναι", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("'Ακυρο", ButtonBar.ButtonData.CANCEL_CLOSE);
//        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
//        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            alert.getDialogPane().getButtonTypes().add(okButton);
            alert.getDialogPane().getButtonTypes().add(cancelButton);
//        okButton.setDefaultButton( true );
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == okButton) {

                try {
                    PLAYER_SERVICE.delete(username);
                    tableManager.deleteObject(player);
                } catch (SifinosException ex) {
//                    Alert alertDeletion = new Alert(Alert.AlertType.ERROR, ex.getMessage());
//                    alertDeletion.initModality(Modality.APPLICATION_MODAL);
//                    alertDeletion.setResizable(true);
//                    alertDeletion.getDialogPane().setPrefWidth(450);
//                    alertDeletion.showAndWait();
                }
            }
            if (result.get() == cancelButton) {
            }
        }
    }

    @FXML
    void close(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private Stage getStage() {
        return (Stage) table.getScene().getWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableManager = new TableManager<>(table, new HashMap<TableColumn, Callback>() {
            {
                put(usernameCol, new PropertyValueFactory<>("username"));
                put(nameCol, new PropertyValueFactory<>("name"));
            }
        });
//        tableManager.addObjects(FXCollections.observableArrayList(PLAYER_SERVICE.find()));
        tableManager.addObjects(PLAYER_SERVICE.find());

    }
}

//    @FXML
//    void addListInTable(ActionEvent event) throws IOException {
//        table = new TableView<Player>();
//        username.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<Player>, String>, ObservableValue<String>>() {
//        ObservableList<Player> data = FXCollections.observableArrayList(playerService.find());
//        data = (ObservableList<Player>) playerService.find();
//        usernameCol.getCellValueFactory();
//    }
