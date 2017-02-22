package gr.anneta.civilization_selector.domain;

/**
 *
 * @author chsifinos@gmail.com
 */
public class Civilization {

    private String title;

    public Civilization() {
        this.title = "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {

        // Convert the civilization object to string title.
        return "(Title):" + this.title ;
    }
}
