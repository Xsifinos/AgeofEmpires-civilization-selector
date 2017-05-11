package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.service.CivilizationService;
import gr.softaware.lib.javafx.control.TableManager;
import gr.softaware.lib.javafx.stage.DeleteModal;
import gr.softaware.lib.javafx.stage.NoRowSelectedModal;
import gr.softaware.lib.javafx.exception.SifinosException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CivilizationManagerController implements Initializable {

    protected static TableManager<Civilization> tableManager;
    private final CivilizationService CIVILIZATION_SERVICE = new CivilizationService();

    @FXML
    private TableView<Civilization> table;
    @FXML
    private TableColumn titleCol;
    @FXML
    private TableColumn specialUnitCol;
    @FXML
    private TableColumn barracksCol;
    @FXML
    private TableColumn archeryCol;
    @FXML
    private TableColumn stableCol;
//    private  String username;

    @FXML
    void create(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Age of Empires Civilization Selector - Create Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CivilizationCreateView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        Civilization civilization = tableManager.getSelectedObject();
        if (civilization == null) {
            new NoRowSelectedModal().show();
//            Alert alertNullPointer = new Alert(Alert.AlertType.NONE);
//            alertNullPointer.setTitle("ΕΠΕΞΕΡΓΑΣΙΑ ΠΑΙΚΤΗ");
//            alertNullPointer.setHeaderText(null);
//            ImageView imageView = new ImageView(getClass().getResource("/files/images/1492875257_alert.png").toExternalForm());
//            alertNullPointer.setGraphic(imageView);
//            alertNullPointer.initModality(Modality.APPLICATION_MODAL);
//            alertNullPointer.setResizable(true);
//            Label label = new Label("Δεν έχετε επιλέξει κανέναν παίκτη!!");
//            label.setWrapText(true);
//            alertNullPointer.getDialogPane().setContent(label);
////            alertNullPointer.getDialogPane().setPrefWidth(300);
//            ButtonType cancelButton = new ButtonType("Κλείσιμο", ButtonBar.ButtonData.CANCEL_CLOSE);
//            alertNullPointer.getDialogPane().getButtonTypes().add(cancelButton);
//            alertNullPointer.showAndWait();
        } else {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Age of Empires Civilization Selector - Edit Civilization");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/CivilizationUpdateView.fxml"));
            Parent root = (Parent) loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        Civilization civilization = tableManager.getSelectedObject();
        if (civilization == null) {
            new NoRowSelectedModal().show();
        } else {
            int id = civilization.getId();
            DeleteModal deleteModal = new DeleteModal.DeleteModalBuilder()
                    .title("Διαγραφή Παίκτη")
                    .body("Είστε σίγουρος/η για τη διαγραφή του λαού με id " + "'" + id + "'" + " ?")
                    .action(() -> {
                        try {
                            CIVILIZATION_SERVICE.delete(civilization);
                            tableManager.deleteObject(civilization);
                        } catch (SifinosException ex) {
//                    Alert alertDeletion = new Alert(Alert.AlertType.ERROR, ex.getMessage());
//                    alertDeletion.initModality(Modality.APPLICATION_MODAL);
//                    alertDeletion.setResizable(true);
//                    alertDeletion.getDialogPane().setPrefWidth(450);
//                    alertDeletion.showAndWait();
                        }
                    })
                    .build();
            deleteModal.show();
////        Player player = new Player();
////        String username = null;
////        usernameCol.getCellValueFactory();
//            Alert alert = new Alert(Alert.AlertType.NONE);
//            DialogPane dialogPane = alert.getDialogPane();
//            alert.setTitle("ΔΙΑΓΡΑΦΗ ΠΑΙΚΤΗ");
//            alert.setHeaderText(null);
////        Graphics graphic;  // You can't create new object Graphics because of abstract.
////        Image image1 = new Image("/files/images/1492875257_alert");
//            ImageView imageView = new ImageView(getClass().getResource("/files/images/1492875257_alert.png").toExternalForm());
////                new ImageView(new Image(getClass().getResourceAsStream("/files/images/1492875257_alert.png")));
//            alert.setGraphic(imageView);
//            alert.initModality(Modality.APPLICATION_MODAL);
////        alert.getDialogPane().setPrefWidth(550);
//            alert.setResizable(true);
////        alert.setContentText("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username?");
////        alert.getDialogPane().setPrefSize(800,100);  // Not a recommended solution for different projects.
//            Label label = new Label("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username " + "'" + username + "'" + "?");
////        Text text=new Text("Είστε σίγουρος/η για τη διαγραφή του παίκτη με username " + "'" + username + "'" + " ?");
//            label.setWrapText(true);
////        text.setWrappingWidth(500);  // If i want to wrap in different lines using Text.
//            alert.getDialogPane().setContent(label);
//
//            ButtonType okButton = new ButtonType("Ναι", ButtonBar.ButtonData.OK_DONE);
//            ButtonType cancelButton = new ButtonType("'Ακυρο", ButtonBar.ButtonData.CANCEL_CLOSE);
//
//            alert.getDialogPane().getButtonTypes().add(okButton);
//            alert.getDialogPane().getButtonTypes().add(cancelButton);
//
////            dialogPane.getStylesheets().add(
////                    getClass().getResource("/files/css/deleteDialog.css").toExternalForm());
////            dialogPane.lookupButton(okButton).getStyleClass().add("dialog-pane .button");
//            dialogPane.getScene().getStylesheets().add("/files/css/deleteDialog.css");
//
////              dialogPane.lookupButton(okButton).getStyleClass().add(getClass().getResource("/files/css/common.css").toExternalForm());
////            dialogPane.lookupButton(okButton).getScene().getStylesheets().add(getClass().getResource("/files/css/common.css").toExternalForm());
////            dialogPane.setStyle("-fx-background-color: #d9534f;"+"-fx-font-weight: bold;-fx-cursor:hand;");
////            cancelButton.getButtonData().isDefaultButton();
////            okButton.getButtonData().isCancelButton();
////            okButton.setDefaultButton( true );
////            alert.getDialogPane().lookupButton(okButton).getStyleClass().add(getClass().getResource("/files/css/common.css").toExternalForm());
////            Button noButton = (Button) alert.getDialogPane().lookupButton(ButtonType.NO);
////            noButton.setDefaultButton(true);
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == okButton) {
//
//                try {
//                    PLAYER_SERVICE.delete(username);
//                    tableManager.deleteObject(player);
//                } catch (SifinosException ex) {
////                    Alert alertDeletion = new Alert(Alert.AlertType.ERROR, ex.getMessage());
////                    alertDeletion.initModality(Modality.APPLICATION_MODAL);
////                    alertDeletion.setResizable(true);
////                    alertDeletion.getDialogPane().setPrefWidth(450);
////                    alertDeletion.showAndWait();
//                }
//            }
//            if (result.get() == cancelButton) {
//            }
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
                put(titleCol, new PropertyValueFactory<>("title"));
                put(specialUnitCol, new PropertyValueFactory<>("specialUnit"));
            }
        });
//        tableManager.addObjects(FXCollections.observableArrayList(PLAYER_SERVICE.find()));
        tableManager.addObjects(CIVILIZATION_SERVICE.find());

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
