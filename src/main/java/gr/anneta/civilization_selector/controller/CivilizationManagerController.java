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

    @FXML
    void create(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Age of Empires Civilization Selector - Create Civilization");
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
            String title = civilization.getTitle();
            DeleteModal deleteModal = new DeleteModal.DeleteModalBuilder()
                    .title("Διαγραφή Λαού")
                    .body("Είστε σίγουρος/η για τη διαγραφή του λαού " + "'" + title + "'" + " ?")
                    .action(() -> {
                        try {
                            CIVILIZATION_SERVICE.delete(civilization);
                            tableManager.deleteObject(civilization);
                        } catch (SifinosException ex) {
                        }
                    })
                    .build();
            deleteModal.show();
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
                put(barracksCol, new PropertyValueFactory<>("barracks"));
                put(archeryCol, new PropertyValueFactory<>("archery"));
                put(stableCol, new PropertyValueFactory<>("stable"));
            }
        });
        tableManager.addObjects(CIVILIZATION_SERVICE.find());
    }
}

