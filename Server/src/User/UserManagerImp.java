package User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by joseja on 10/21/16.
 */
public class UserManagerImp implements UserManager {

    private static HashMap<User, String> tokens;

    public UserManagerImp() {
        tokens = new HashMap<>();
        User testUser1 = new User();
        tokens.put(testUser1,
                UUID.nameUUIDFromBytes((testUser1.getUsername() + testUser1.getPassword()).getBytes()).toString());
    }

    public void saveUser(String username, String password) {
        User user = new User(username, password);
        tokens.put(user, UUID.nameUUIDFromBytes((username + password).getBytes()).toString());
    }

    public String getToken(String username, String password) {
        User pepe = new User(username, password);
        return tokens.get(pepe);
    }

    @Override
    public boolean isUser(String token) {
        return tokens.containsValue(token);
    }

    public User getUser(String token) {
        for (Map.Entry<User, String> entry : tokens.entrySet()) {
            User user = entry.getKey();
            if (entry.getValue().equals(token))
                return user;
        }
        return null;
    }

    public boolean isAdmin(String token) {
        if (token.equals(UUID.nameUUIDFromBytes(("adminadmin").getBytes()).toString())) {
            return true;
        } else {
            return false;
        }
    }
}
