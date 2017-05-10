package gr.softaware.lib.javafx.stage;

import gr.softaware.lib.javafx.misc.NodeUtils;
import java.util.List;
import java.util.Optional;
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
public final class DeleteModal {

    private static final String CANCEL_BTN_TEXT = "Άκυρο";
    private static final String DELETE_BTN_TEXT = "Διαγραφή";

    private final String title;
    private final String body;
    private final DeleteModalAction action;

    private DeleteModal(DeleteModalBuilder builder) {
        this.title = builder.title;
        this.body = builder.body;
        this.action = builder.action;
    }

    public static class DeleteModalBuilder {

        private String title;
        private String body;
        private DeleteModalAction action;

        public DeleteModalBuilder() {
            this.title = null;
            this.body = null;
            this.action = null;
        }

        public DeleteModalBuilder title(String title) {
            this.title = title;
            return this;
        }

        public DeleteModalBuilder body(String body) {
            this.body = body;
            return this;
        }

        public DeleteModalBuilder action(DeleteModalAction action) {
            this.action = action;
            return this;
        }

        public DeleteModal build() {
            return new DeleteModal(this);
        }
    }

    public void show() {
        // Initializa the alert modal.
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle(this.title);
        alert.setHeaderText(null);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setResizable(true);

        // Change the graphic.
        ImageView imageView = new ImageView(getClass().getResource("/files/images/1492875257_alert.png").toExternalForm());
        alert.setGraphic(imageView);

        // Add the body.
        Label bodyLabel = new Label(this.body);
        bodyLabel.setWrapText(true);
        alert.getDialogPane().setContent(bodyLabel);

        // Add buttons
        DialogPane dialogPane = alert.getDialogPane();
        ButtonType cancelButtonType = new ButtonType(CANCEL_BTN_TEXT, ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType deleteButtonType = new ButtonType(DELETE_BTN_TEXT, ButtonBar.ButtonData.OK_DONE);
        dialogPane.getButtonTypes().add(cancelButtonType);
        dialogPane.getButtonTypes().add(deleteButtonType);
        
        // Edit css.
        dialogPane.getScene().getStylesheets().add("/files/css/fextile.css");
        dialogPane.getScene().getStylesheets().add("/files/css/common.css");
        dialogPane.getStyleClass().remove("alert");
        dialogPane.getStyleClass().add("alert-container");

        // Set the correct css for buttons.
        List<Node> nodes = NodeUtils.getAllNodes(dialogPane);
        Button cancelButton = null;
        Button deleteButton = null;
        for (Node node : nodes) {
            if (node instanceof Button && ((Button) node).getText().equals(CANCEL_BTN_TEXT)) {
                cancelButton = (Button) node;
            }
            if (node instanceof Button && ((Button) node).getText().equals(DELETE_BTN_TEXT)) {
                deleteButton = (Button) node;
            }
        }
        cancelButton.getStyleClass().add("btn-default");
        deleteButton.getStyleClass().add("btn-danger");

        // Show alert.
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == deleteButtonType) {
            this.action.delete();
        }
    }
}
