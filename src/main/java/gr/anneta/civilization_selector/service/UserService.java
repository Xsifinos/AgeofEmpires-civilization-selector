package gr.anneta.civilization_selector.service;

import gr.anneta.civilization_selector.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chsifinos@gmail.com
 */
public class UserService {

    private ArrayList<User> userslist;

    public UserService() {
        userslist = new ArrayList<User>();
    }

    public User create(User user) {
        userslist.add(user);
        return user;
    }

//    public User create(String name, String username) {
//        User user = new User(name, username);
//        userslist.add(user);
//        return user;
//    }
//     public User create(String name, String username) {
//        User user = new User();
//        user.setName(name);
//        user.setUsername(username);
//        userslist.add(user);
//        return user;
//    }
// public User delete(String name) {
//        User userToReturn = null;
//        for (User user : userslist) {
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
        for (User user : userslist) {
            if (name.equals(user.getName())) {
                userslist.remove(user);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    public boolean isEmpty() {
        return userslist.isEmpty();
    }

    public List<User> find() {
        List<User> usersClone = new ArrayList<>(this.userslist);
        return usersClone;
    }
}
