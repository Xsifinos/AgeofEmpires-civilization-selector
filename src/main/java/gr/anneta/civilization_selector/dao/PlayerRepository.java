package gr.anneta.civilization_selector.dao;

import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.lib.SifinosException;
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
public class PlayerRepository extends FileUtils {

    public PlayerRepository() {
        super("/home/sifis/Project/AgeofEmpires/database/player.repository");
    }

    public Player create(Player player) throws SifinosException {
        String name = player.getName().replace(" ", "");
        String username = player.getUsername().replace(" ", "");
        Player playerWithoutSpaces = new Player(name, username);
        // Create an ObjectMapper object to use to convert object to JSON String.
        ObjectMapper mapper = new ObjectMapper();
        // Initialize local variable.
        String jsonInString = null;
        try {
            // Use a for loop to check if the player already exists.
            for (Player current : find()) {
                // The condition to search the player.
                if (playerWithoutSpaces.equals(current)) {
                    throw new SifinosException("WARNING : Username already exists! Try again.");
                }
            }
            // Convert object to JSON String.
            jsonInString = mapper.writeValueAsString(playerWithoutSpaces);

        } catch (IOException ex) {
            throw new RuntimeException();
        }
        // Append JSON String to file.
        appendInFile(jsonInString + "\n");

        return playerWithoutSpaces;
    }

    public Player readByUsername(String username) throws SifinosException {
        // Use a for loop to search the player with the username.  
        for (Player player : find()) {
            if (username.equals(player.getUsername())) {
                return player;
            }
        }
        return null;
    }

    public Player update(Player player) throws SifinosException {
        String name = player.getName().replace(" ", "");
        String username = player.getUsername().replace(" ", "");
        Player playerWithoutSpaces = new Player(name, username);

        // Create list to use to manipulate the players.
        List<Player> playerList = find();

        // Use a for loop to the current list to find the player and replace him.
        for (Player current : playerList) {
            // The condition to find the player. 
            if (playerWithoutSpaces.equals(current)) {
                playerList.remove(current);
                playerList.add(playerWithoutSpaces);

                // Create new empty file to append the new list as JSON.
                emptyFile();

                // Use a for loop to create JSON in file.
                for (Player current1 : playerList) {
                    create(current1);
                }
                // Use a break to stop the for loop if the player is found.
                break;
            }
        }
        return playerWithoutSpaces;
    }

    public boolean delete(Player player) throws SifinosException {
        boolean isDeleted = false;
        // Create list to use to manipulate the players.
        List<Player> playerList = find();
        
        playerList.remove(player);

        // Create new empty file to append the new list as JSON.
        emptyFile();

        // Use a for loop to create JSON in file.
        for (Player current : playerList) {
            create(current);
            
            isDeleted = true;
        }
        return isDeleted;
    }

    public List<Player> find() {
        // Create an ObjectMapper object to use to convert JSON from String to object.
        ObjectMapper mapper = new ObjectMapper();

        // Initialize local variable.
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/sifis/Project/AgeofEmpires/database/player.repository"));
        } catch (FileNotFoundException ex) {
        }
        // Create new list to use to add from the file the created players.
        List<Player> playerList = new ArrayList<>();

        // Declare local variable.
        String jsonInString;

        try {
            // Use a while loop to read file line by line.
            while ((jsonInString = br.readLine()) != null) {
                // Convert JSON from String to object.
                Player player = mapper.readValue(jsonInString, Player.class);
                // Add the object to playerlist.
                playerList.add(player);
            }
        } catch (IOException ex) {
        }
        return playerList;
    }
}
