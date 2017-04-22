package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.service.PlayerService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlayersController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn usernameCol;
    @FXML
    private TableColumn nameCol;

    @FXML
    void addListInTable(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        PlayerService playerService = new PlayerService();
//        final Player player = new Player();
//        List<Player> playerList = playerService.find();
//        Player player=data.get(0);
//        table = new TableView<Player>();
//        username.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<Player>, String>, ObservableValue<String>>() {
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<Player>, String> param) {
//                return return new SimpleStringProperty(player.getUsername()));;
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });

//        table.setEditable(true);
//        TableColumn username = new TableColumn("Username");
//        TableColumn name = new TableColumn("Name");
//        ObservableList<Player> data = FXCollections.observableArrayList(playerList);
//        table.setItems(data);
//        username.setCellValueFactory(new PropertyValueFactory<>(player.getUsername()));
//        name.setCellValueFactory(new PropertyValueFactory<>(player.getName()));
//        NameCol.getCellObservableValue();
//        table.getColumns().addAll(username, name);
//        table.getItems(data);
//        data = (ObservableList<Player>) playerService.find();
//               
//        tableColumn.getCellValueFactory();
//        tableColumn.setCellValueFactory(playerList());

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerCreateView.fxml"));
//        Parent root = (Parent) loader.load();
//        stage.setScene(new Scene(root));
//        stage.show();
    }

    @FXML
    void create(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Age of Empires Civilization Selector - Create Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerCreateView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Age of Empires Civilization Selector - Edit Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerUpdateView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Age of Empires Civilization Selector - Delete Player");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PlayerDeleteView.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = getStage();
        stage.close();
    }

    @FXML
    private Stage getStage() {
        Stage stage = (Stage) table.getScene().getWindow();
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
