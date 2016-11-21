package User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by joseja on 10/21/16.
 */
public class UserManagerImp implements UserManager {

    private static HashMap<UserImp, String> tokens;

    public UserManagerImp() {
        tokens = new HashMap<>();
        UserImp testUserImp1 = new UserImp();
        tokens.put(testUserImp1,
                UUID.nameUUIDFromBytes((testUserImp1.getUsername() + testUserImp1.getPassword()).getBytes()).toString());
    }

    public void saveUser(String username, String password) {
        UserImp userImp = new UserImp(username, password);
        tokens.put(userImp, UUID.nameUUIDFromBytes((username + password).getBytes()).toString());
    }

    public String getToken(String username, String password) {
        UserImp pepe = new UserImp(username, password);
        return tokens.get(pepe);
    }

    @Override
    public boolean isUser(String token) {
        return tokens.containsValue(token);
    }

    public UserImp getUser(String token) {
        for (Map.Entry<UserImp, String> entry : tokens.entrySet()) {
            UserImp userImp = entry.getKey();
            if (entry.getValue().equals(token))
                return userImp;
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
