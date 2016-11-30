package User;

import Ticket.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * Created by joseja on 11/21/16.
 */
@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public void insert(User user) {
        em.persist(user);
        em.flush();
    }

    public User findByName(String name) {
        return (User) em.createQuery("select user from User user " +
                "where user.username = :name")
                .setParameter("name", name)
                .getSingleResult();
    }

    public User findByToken(String token) {
        return (User) em.createQuery("select user from User user " +
                "where user.token = :token")
                .setParameter("token", token)
                .getSingleResult();
    }

    public boolean tokenExists(String token) {
        if (((User) em.createQuery("select user from User user " +
                "where user.token = :token")
                .setParameter("token", token)
                .getSingleResult())
                .getToken().equals(token)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdmin(String token) {
        if (((User) em.createQuery("select user from User user " +
                "where user.token = :token")
                .setParameter("token", token).getSingleResult())
                .getToken()
                .equals(UUID.nameUUIDFromBytes(("adminadmin").getBytes()).toString())) {
            return true;
        } else {
            return false;
        }
    }

    public List<Ticket> getTickets(String token) {
        return ((User) em.createQuery("select user from User user " +
                "where user.token = :token")
                .setParameter("token", token)
                .getSingleResult())
                .getTickets();
    }

    public User update(User user) {
        return em.merge(user);
    }
}
