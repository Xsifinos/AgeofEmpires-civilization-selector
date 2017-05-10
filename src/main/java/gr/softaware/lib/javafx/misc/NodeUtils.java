package gr.softaware.lib.javafx.misc;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ButtonBar;

/**
 *
 * @author chsifinos@gmail.com
 */
public class NodeUtils {

    public static ArrayList<Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<>();
        addAllDescendents(root, nodes);
        return nodes;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        // Get children.
        List<Node> children;
        if(parent instanceof ButtonBar){
            children = ((ButtonBar)parent).getButtons();
        } else {
            children = parent.getChildrenUnmodifiable();
        }
        
        //
        for (Node node : children) {
            nodes.add(node);
            if (node instanceof Parent) {
                addAllDescendents((Parent) node, nodes);
            }
        }
    }
}
