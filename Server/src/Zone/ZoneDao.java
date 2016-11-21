package Zone;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by joseja on 11/21/16.
 */
@Repository
@Transactional
public class ZoneDao {

    @PersistenceContext
    EntityManager em;

    public Zone find(int id) {
        return em.find(Zone.class, id);
    }

    public void insert(Zone zone) {
        em.persist(zone);
        em.flush();
    }
}
