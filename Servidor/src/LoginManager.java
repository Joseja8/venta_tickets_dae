/**
 * Created by joseja on 10/21/16.
 */
public interface LoginManager {

    void saveUser(String username, String password);
    String getToken(String username, String password);
}
