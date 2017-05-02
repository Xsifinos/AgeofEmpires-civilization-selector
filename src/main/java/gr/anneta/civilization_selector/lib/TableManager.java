package gr.anneta.civilization_selector.lib;

import java.util.List;
import java.util.Map;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * Mar 21, 2013, 6:22:50 PM
 *
 * @author syggouroglou@gmail.com
 * @param <T> The type of the objects that will be displayed in the table.
 */
public final class TableManager<T> {

    private final TableView<T> table;

    public TableManager(TableView<T> table, Map<TableColumn, Callback> tableColumns) {
        //Initialize variables.
        this.table = table;

        // Set values in TableManager Columns.
        for (Map.Entry<TableColumn, Callback> entry : tableColumns.entrySet()) {
            entry.getKey().setCellValueFactory(entry.getValue());
        }
    }

//    public void clearObjects(List<T> list) {
//        this.table.getItems().clear();
//    }
    public void addObjects(List<T> list) {
        this.table.getItems().addAll(list);
    }

    public void createObject(T item) {
        this.table.getItems().add(item);
    }

    public T getSelectedObject() {
        return this.table.getSelectionModel().getSelectedItem();
    }

    public void updateObject(T item) {
        int index = this.table.getItems().indexOf(item);
        this.table.getItems().set(index, item);
    }

    public void deleteObject(T item) {
        this.table.getItems().remove(item);
    }
}
