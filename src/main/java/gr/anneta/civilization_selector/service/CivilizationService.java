package gr.anneta.civilization_selector.service;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chsifinos@gmail.com
 */
public class CivilizationService {

    private List<Civilization> civilizations;

    public CivilizationService() {
        this.civilizations = new ArrayList<>();
    }

    public Civilization create(Civilization civilization) {
        civilizations.add(civilization);
        return civilization;
    }

    public Civilization create(String title) {
        Civilization civilization = new Civilization();
        civilization.setTitle(title);
        civilizations.add(civilization);
        return civilization;
    }

    public boolean delete(Civilization civilization) {
        return this.delete(civilization.getTitle());
    }
//    public boolean delete(Civilization civilization) {
//        boolean civilisDeleted=false;
//        for (Civilization civilization: civilizations) {
//            if (civilization.equals(civilization.getTitle())) {
//                civilizations.remove(civilization);
//                civilisDeleted = true;
//                break;
//        
//        }
//        return civilisDeleted;
//    }
//    

    public boolean delete(String title) {
        boolean isDeleted = false;
        for (Civilization civilization : civilizations) {
            if (title.equals(civilization.getTitle())) {
                civilizations.remove(civilization);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

     public boolean isEmpty() {
        return civilizations.isEmpty();
    }
     
    public List<Civilization> find() {
        List<Civilization> civilsClone = new ArrayList<>(this.civilizations);
        return civilsClone;
    }
}
