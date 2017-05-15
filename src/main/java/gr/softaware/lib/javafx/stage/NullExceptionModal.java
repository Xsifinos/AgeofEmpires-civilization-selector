package gr.softaware.lib.javafx.stage;

import gr.softaware.lib.javafx.misc.NodeUtils;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;

/**
 *
 * @author chsifinos@gmail.com
 */
public class NullExceptionModal {

    private static final String CANCEL_BTN_TEXT = "Κλείσιμο";

    public void show() {
        // Initialize alert.
        Alert alertNullPointer = new Alert(Alert.AlertType.NONE);
        alertNullPointer.setTitle("Ουπς");
        alertNullPointer.setHeaderText(null);
        alertNullPointer.initModality(Modality.APPLICATION_MODAL);
        alertNullPointer.setResizable(true);

        // Add the correct image.
        ImageView imageView = new ImageView(getClass().getResource("/files/images/1492875257_alert.png").toExternalForm());
        alertNullPointer.setGraphic(imageView);

        // Add body.
        Label label = new Label("Δεν έχετε εισάγει στοιχεία στα πεδία.");
        label.setWrapText(true);
        alertNullPointer.getDialogPane().setContent(label);

        // Add buttons.
        DialogPane dialogPane = alertNullPointer.getDialogPane();
        ButtonType cancelButtonType = new ButtonType(CANCEL_BTN_TEXT, ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(cancelButtonType);

        // Set the correct css for buttons.
        List<Node> nodes = NodeUtils.getAllNodes(dialogPane);
        Button cancelButton = null;
        for (Node node : nodes) {
            if (node instanceof Button && ((Button) node).getText().equals(CANCEL_BTN_TEXT)) {
                cancelButton = (Button) node;
            }
        }
        cancelButton.getStyleClass().add("btn-default");

        // Set css to stage.
        dialogPane.getScene().getStylesheets().add("/files/css/fextile.css");
        dialogPane.getScene().getStylesheets().add("/files/css/common.css");
        dialogPane.getStyleClass().remove("alert");
        dialogPane.getStyleClass().add("alert-container");

        // Show it.
        alertNullPointer.showAndWait();
    }

}
