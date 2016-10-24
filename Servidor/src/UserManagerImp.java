import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by joseja on 10/21/16.
 */
public class UserManagerImp {

    private static HashMap<User, String> tokens = new HashMap<>();

    public static void saveUser(String username, String password) {
        User pepe = new User(username, password);
        tokens.put(pepe, UUID.nameUUIDFromBytes((username + password).getBytes()).toString());
    }

    public static String getToken(String username, String password) {
        User pepe = new User(username, password);
        return tokens.get(pepe);
    }

    public static User getUser(String token) {
        for (Map.Entry<User, String> entry : tokens.entrySet()) {
            User user = entry.getKey();
            if (entry.getValue().equals(token))
                return user;
        }
        return null;
    }

    public static boolean isAdmin(String token) {
        if (token.equals(UUID.nameUUIDFromBytes(("adminadmin").getBytes()).toString())) {
            return true;
        } else {
            return false;
        }
    }
}
