import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

/**
 * Created by joseja on 10/21/16.
 */
public class LoginManagerImp implements LoginManager {

    public Map<User, String> tokens;

    @Override
    public void saveUser(String username, String password) {
        tokens.put(new User(username, password), String.valueOf(DigestUtils.md5(username+password)));
    }

    @Override
    public String getToken(String username, String password) {
        return tokens.get(username+password);
    }

    @Override
    public User getUser(String token) {
        for (Map.Entry<User, String> entry : tokens.entrySet()) {
            User user = entry.getKey();
            if (entry.getValue().equals(token))
                return user;
        }
        return null;
    }
}
