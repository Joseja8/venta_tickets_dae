package User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by joseja on 11/21/16.
 */
@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public User find(int id) {
        return em.find(User.class, id);
    }

    public void insert(User user) {
        em.persist(user);
        em.flush();
    }
}
