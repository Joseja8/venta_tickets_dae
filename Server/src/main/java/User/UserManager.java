package User;

/**
 * Created by joseja on 10/21/16.
 */
public interface UserManager {

    void saveUser(String username, String password);
    User getUser(String token);
    String getToken(String username, String password);
    boolean isUser(String token);
    boolean isAdmin(String token);
}
