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

    private PlayerRepository playerRepository;

    public PlayerService() {
        playerRepository = new PlayerRepository();
    }

    public Player create(Player player) throws SifinosException {
        // Argument validation.
        if (player == null) {
            throw new SifinosException("WARNING : Null! Please enter the username.");
        }
        // Business rules.
        if (player.getName() == null || player.getUsername() == null) {
            throw new SifinosException("WARNING : Null! Please enter the name.");
        }
        if (player.getName().trim().isEmpty() || player.getUsername().trim().isEmpty()) {
            throw new SifinosException("WARNING : Empty space! Please enter the username.");
        }

        playerRepository.create(player);

        return player;
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

        return isDeleted;
    }

    public boolean update(Player player) throws SifinosException {
        // Argument validation.
        if (player == null) {
            return false;
        }
        // Business rules.
        if (player.getName() == null || player.getUsername() == null) {
            return false;
        }
        if (player.getName().trim().isEmpty() || player.getUsername().trim().isEmpty()) {
            return false;
        }
        boolean isUpdated = false;

        playerRepository.update(player);

        return isUpdated;
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
