package gr.anneta.civilization_selector.domain;

/**
 *
 * @author chsifinos@gmail.com
 */
public class Civilization {

    private int id;
    private String title;
    private String specialUnit;
    private boolean barracks;
    private boolean archery;
    private boolean stable;

    public Civilization() {
        this.id = 0;
        this.title = "";
        this.specialUnit = "";
        this.barracks = false;
        this.archery = false;
        this.stable = false;
    }

//    public Civilization(String title) {
//        this.title = title;
//    }
//
//    public Civilization(int id) {
//        this.id = id;
//    }
//    
//    public Civilization(String title, int id) {
//        this.title = title;
//        this.id = id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialUnit() {
        return specialUnit;
    }

    public void setSpecialUnit(String specialUnit) {
        this.specialUnit = specialUnit;
    }

    public boolean getBarracks() {
        return barracks;
    }

    public void setBarracks(boolean barracks) {
        this.barracks = barracks;
    }

    public boolean getArchery() {
        return archery;
    }

    public void setArchery(boolean archery) {
        this.archery = archery;
    }

    public boolean getStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    @Override
    public String toString() {

        // Convert the civilization object to string title.
        return "Title:" + this.title + "\n" + "Id:" + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Civilization)) {
            return false;
        }

        Civilization civilToCheck = (Civilization) obj;
//        if (this.title.equals(civilToCheck.getTitle())) {
        if (this.id == civilToCheck.getId()) {
            return true;
        }

        return false;
    }
}
