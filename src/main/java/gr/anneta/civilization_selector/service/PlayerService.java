package gr.anneta.civilization_selector.service;

import gr.anneta.civilization_selector.dao.FileUtils;
import gr.anneta.civilization_selector.dao.PlayerRepository;
import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.lib.SifinosException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chsifinos@gmail.com
 */
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService() {
        playerRepository = new PlayerRepository();
    }

    public Player create(Player player) throws SifinosException {
        // Argument validation.
        if (player == null) {
            throw new SifinosException("WARNING : Null! Try again.");
        }
        // Business rules.
        if (player.getName() == null || player.getUsername() == null) {
            throw new SifinosException("WARNING : Null! Try again.");
        }
        if (player.getUsername().trim().isEmpty() && player.getName().trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Try again.");
        }
        if (player.getName().trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Please enter your name.");
        }
        if (player.getUsername().trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Please enter your username.");
        }

        String name = player.getName().replace(" ", "");
        String username = player.getUsername().replace(" ", "");
        Player player1 = new Player(name, username);

        playerRepository.create(player1);

        return player1;
    }

    public boolean delete(String username) throws SifinosException {
        // Argument validation.
        if (username == null) {
            throw new SifinosException("WARNING : Null! Please enter the username.");
        }
        // Business rules.
        if (username.trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Please enter the username.");
        }
        if (username.indexOf(" ") >= 0) {
            throw new SifinosException("WARNING : Try again without empty spaces.");
        }
        boolean isDeleted = false;

        Player player = playerRepository.readByUsername(username);
        if (player == null) {
            throw new SifinosException("WARNING : Username does not exist! Try again.");
        }
        playerRepository.delete(player);
        
        isDeleted = true;
        
        return isDeleted;
    }

    public Player update(Player player) throws SifinosException {
        // Argument validation.
        if (player == null) {
            throw new SifinosException("WARNING : Null! Try again.");
        }
        // Business rules.
        if (player.getName() == null || player.getUsername() == null) {
            throw new SifinosException("WARNING : Null! Try again.");
        }
        if (player.getName().trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Please enter your name.");
        }

        String name = player.getName().replace(" ", "");
        String username = player.getUsername().replace(" ", "");
        Player player1 = new Player(name, username);

        playerRepository.update(player1);

        return player1;
    }

    public boolean isEmpty() {
        if (playerRepository.find().isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Player> find() {

        List<Player> players = playerRepository.find();

        return players;
    }
}
