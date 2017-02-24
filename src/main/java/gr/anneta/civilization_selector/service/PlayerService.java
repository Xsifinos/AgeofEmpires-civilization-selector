package gr.anneta.civilization_selector.service;

import gr.anneta.civilization_selector.domain.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chsifinos@gmail.com
 */
public class PlayerService {

    private ArrayList<Player> playerslist;

    public PlayerService() {
        playerslist = new ArrayList<Player>();
    }

    public Player create(Player player) {
        playerslist.add(player);
        return player;
    }

//    public Player create(String name, String username) {
//        Player user = new Player(name, username);
//        userslist.add(user);
//        return user;
//    }
//     public Player create(String name, String username) {
//        Player user = new Player();
//        user.setName(name);
//        user.setUsername(username);
//        userslist.add(user);
//        return user;
//    }
// public Player delete(String name) {
//        Player userToReturn = null;
//        for (Player user : userslist) {
//            if (name.equals(user.getName())) {
//                userslist.remove(user);
//                userToReturn = user;
//                break;
//            }
//        }
//
//        return userToReturn;
//    }
    public boolean delete(String name) {
        boolean isDeleted = false;
        for (Player player : playerslist) {
            if (name.equals(player.getName())) {
                playerslist.remove(player);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public boolean isEmpty() {
        return playerslist.isEmpty();
    }

    public List<Player> find() {
        List<Player> playersClone = new ArrayList<>(this.userslist);
        return playersClone;
    }
}
