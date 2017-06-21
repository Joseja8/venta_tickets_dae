package User;

import java.util.UUID;

/**
 * Created by joseja on 10/21/16.
 */
public class UserManagerImp implements UserManager {

    private UserDao userDao;

    public UserManagerImp() {
    }

    public void saveUser(String username, String password) {
        User user = new User(username, password);
        String token = UUID.nameUUIDFromBytes((username + password).getBytes()).toString();
        user.setToken(token);
        userDao.insert(user);
    }

    public String getToken(String username, String password) {
        return userDao.findByName(username).getToken();
    }

    @Override
    public boolean isUser(String token) {
        return userDao.tokenExists(token);
    }

    public User getUser(String token) {
        return userDao.findByToken(token);
    }

    public boolean isAdmin(String token) {
        return userDao.isAdmin(token);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
