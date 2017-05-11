package gr.anneta.civilization_selector.service;

//import gr.anneta.civilization_selector.dao.CivilizationRepository;
import gr.anneta.civilization_selector.domain.Civilization;
import gr.softaware.lib.javafx.exception.SifinosException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author chsifinos@gmail.com
 */
public class CivilizationService {

//    private final CivilizationRepository civilizationRepository;

    private List<Civilization> civilizations;
    public CivilizationService() {
//        civilizationRepository = new CivilizationRepository();
        this.civilizations = new ArrayList<>();
    }

    public Civilization create(Civilization civilization) throws SifinosException {
//        civilizationRepository.create(civilization);
        civilizations.add(civilization);
        return civilization;
    }

//    public Civilization create(String title) {
//        Civilization civilization = new Civilization();
//        civilization.setTitle(title);
//        civilizations.add(civilization);
//        return civilization;
//    }

    public void createAllCivilizations() {
        Civilization civilization;
        String[] titles = new String[]{
            "Aztecs", "Goths", "Briton", "Celts", "Franks", "Teutons", "Vikings", "Byzantines", "Persians",
            "Saracens", "Turks", "Chinese", "Japanese", "Mongols", "Huns", "Koreans", "Mayans", "Spanish"};
        for (int i = 0; i < titles.length; i++) {
            civilization = new Civilization();
            civilization.setTitle(titles[i]);
            civilizations.add(civilization);
        }
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

    /**
     *
     * @param allowduplicates set true in case you allow duplicates. False in
     * case you deny duplicates.
     * @return
     */
    public Civilization getRandomCivilization(boolean allowduplicates) {
        Random random = new Random();
        int temp = random.nextInt(civilizations.size());
        Civilization civilization = civilizations.get(temp);
        if (!allowduplicates) {
            civilizations.remove(temp);
        }
        return civilization;
    }
}

//for (int i = 0; i < consoleUI.getUsernames().size(); i++){
//            String username = consoleUI.getUsernames().get(i);
//            
//            AgeofEmpires ageofEmpires = new AgeofEmpires();
//            String randomCivilization = ageofEmpires.getRandomCivilization();
//            System.out.println(username + ":" + randomCivilization);
//        }

