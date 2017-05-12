package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.service.CivilizationService;
import gr.softaware.lib.javafx.exception.SifinosException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author chsifinos@gmail.com
 */
public class CivilizationCreateController implements Initializable {

    private final CivilizationService CIVILIZATION_SERVICE = new CivilizationService();
    @FXML
    private TextField title;
    @FXML
    private TextField specialUnit;
    @FXML
    private CheckBox barracksBool;
    @FXML
    private CheckBox archeryBool;
    @FXML
    private CheckBox stableBool;
    
    @FXML
    void create(ActionEvent event) {
        Civilization civilization = new Civilization();
        civilization.setTitle(title.getText());
        civilization.setSpecialUnit(specialUnit.getText());
        civilization.setBarracks(barracksBool.isSelected());
        civilization.setArchery(archeryBool.isSelected());
        civilization.setStable(stableBool.isSelected());
        try {
            Civilization civilization1 = CIVILIZATION_SERVICE.create(civilization);
            CivilizationManagerController.tableManager.createObject(civilization1);
            getStage().close();
        } catch (SifinosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.CLOSE);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setResizable(true);
            alert.getDialogPane().setPrefWidth(450);
            alert.showAndWait();
        }
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = getStage();
        stage.close();
    }

    @FXML
    private Stage getStage() {
        Stage stage = (Stage) title.getScene().getWindow();
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
