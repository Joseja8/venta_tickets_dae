import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

/**
 * Created by joseja on 10/21/16.
 */
public class LoginManagerImp implements LoginManager {

    public Map<String, String> tokens;

    @Override
    public void saveUser(String username, String password) {
        tokens.put(username+password, String.valueOf(DigestUtils.md5(username+password)));
    }

    @Override
    public String getToken(String username, String password) {
        return tokens.get(username+password);
    }
}
