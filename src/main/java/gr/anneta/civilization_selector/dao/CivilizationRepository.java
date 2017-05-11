package gr.anneta.civilization_selector.dao;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.softaware.lib.javafx.exception.SifinosException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author chsifinos@gmail.com
 */
public class CivilizationRepository extends FileUtils {

    public CivilizationRepository() {
        super("/home/sifis/Project/AgeofEmpires/database/civilization.repository");
    }

    public Civilization create(Civilization civil) throws SifinosException {
        // Create an ObjectMapper object to use to convert object to JSON String.
        ObjectMapper mapper = new ObjectMapper();
        // Initialize local variable.
        String jsonInString = null;
        try {
            // Use a for loop to check if the civilization already exists.
            for (Civilization current : find()) {
                // The condition to search the civilization.
                if (civil.equals(current)) {
                    throw new SifinosException("WARNING : Civilization already exists! Try again.");
                }
            }
            // Convert object to JSON String.
            jsonInString = mapper.writeValueAsString(civil);

        } catch (IOException ex) {
            throw new RuntimeException();
        }
        // Append JSON String to file.
        appendInFile(jsonInString + "\n");

        return civil;
    }

//    public Civilization readByTitle(String title) throws SifinosException {
//        // Use a for loop to search the player with the username.  
//        for (Civilization civil : find()) {
//            if (title.equals(civil.getTitle())) {
//                System.out.println(civil);
//                return civil;
//            }
//        }
//        return null;
//    }

    public Civilization readById(int id) throws SifinosException {
        // Use a for loop to search the player with the username.  
        for (Civilization civil : find()) {
            if (id == civil.getId()) {
//                System.out.println(civil);
                return civil;
            }
        }
        return null;
    }

    public Civilization update(Civilization civil) throws SifinosException {
        // Create list to use to manipulate the civilizations.
        List<Civilization> civilList = find();

        // Use a for loop to the current list to find the civilization and replace it.
        for (Civilization current : civilList) {
            // The condition to find the civilization. 
            if (civil.equals(current)) {
                civilList.remove(current);
                civilList.add(civil);

                // Create new empty file to append the new list as JSON.
                emptyFile();

                // Use a for loop to create JSON in file.
                for (Civilization current1 : civilList) {
                    create(current1);
                }
                // Use a break to stop the for loop if the civilization is found.
                break;
            }
        }
        return civil;
    }

    public boolean delete(Civilization civil) throws SifinosException {
        boolean isDeleted = false;
        // Create list to use to manipulate the civilizations.
        List<Civilization> civilList = find();

        civilList.remove(civil);

        // Create new empty file to append the new list as JSON.
        emptyFile();

        // Use a for loop to create JSON in file.
        for (Civilization current : civilList) {
            create(current);

            isDeleted = true;
        }
        return isDeleted;
    }

    public List<Civilization> find() {
        // Create an ObjectMapper object to use to convert JSON from String to object.
        ObjectMapper mapper = new ObjectMapper();

        // Initialize local variable.
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/sifis/Project/AgeofEmpires/database/civilization.repository"));
        } catch (FileNotFoundException ex) {
        }
        // Create new list to use to add from the file the created civilizations.
        List<Civilization> civilList = new ArrayList<>();

        // Declare local variable.
        String jsonInString;

        try {
            // Use a while loop to read file line by line.
            while ((jsonInString = br.readLine()) != null) {
                // Convert JSON from String to object.
                Civilization civil = mapper.readValue(jsonInString, Civilization.class);
                // Add the object to civilList.
                civilList.add(civil);
            }
        } catch (IOException ex) {
        }
        return civilList;
    }

}
