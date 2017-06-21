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
    EntityManager entityManager;

    @Transactional
    public Zone find(int id) {
        return entityManager.find(Zone.class, id);
    }

    @Transactional
    public void insert(Zone zone) {
        entityManager.persist(zone);
        entityManager.flush();
    }
}
