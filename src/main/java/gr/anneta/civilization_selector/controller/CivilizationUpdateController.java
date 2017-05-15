package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.service.CivilizationService;
import gr.softaware.lib.javafx.exception.SifinosException;
import gr.softaware.lib.javafx.stage.NullExceptionModal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chsifinos@gmail.com
 */
public class CivilizationUpdateController implements Initializable {

    private final CivilizationService CIVILIZATION_SERVICE = new CivilizationService();
    @FXML
    private Label subtitle;
    @FXML
    protected TextField title;
    @FXML
    protected TextField specialUnit;
    @FXML
    private CheckBox barracksBool;
    @FXML
    private CheckBox archeryBool;
    @FXML
    private CheckBox stableBool;

    private Civilization civilization;

    @FXML
    void editCivilization(ActionEvent event) {
        civilization.setSpecialUnit(specialUnit.getText());
        civilization.setBarracks(barracksBool.isSelected());
        civilization.setArchery(archeryBool.isSelected());
        civilization.setStable(stableBool.isSelected());
        if (civilization == null || civilization.getSpecialUnit().trim().isEmpty()) {
            new NullExceptionModal().show();
        } else {
            try {
                Civilization civilization1 = CIVILIZATION_SERVICE.update(civilization);
                CivilizationManagerController.tableManager.updateObject(civilization1);
                getStage().close();
            } catch (SifinosException ex) {
            }
        }
    }

    @FXML
    void close(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private Stage getStage() {
        return (Stage) subtitle.getScene().getWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        civilization = CivilizationManagerController.tableManager.getSelectedObject();
        title.setText(civilization.getTitle());
        specialUnit.setText(civilization.getSpecialUnit());
        barracksBool.setSelected(civilization.getBarracks());
        archeryBool.setSelected(civilization.getArchery());
        stableBool.setSelected(civilization.getStable());
    }
}
