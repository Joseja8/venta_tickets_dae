package Area;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by joseja on 11/21/16.
 */
@Repository
@Transactional
public class AreaDao {

    @PersistenceContext
    EntityManager em;

    public Area find(int id) {
        return em.find(Area.class, id);
    }

    public void insert(Area area) {
            em.persist(area);
            em.flush();
    }
}
