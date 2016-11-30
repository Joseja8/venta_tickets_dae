package Area;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Area> findAll() {
        return em.createQuery("select area from Area area").getResultList();
    }

    public Area findByCity(String city) {
        return (Area) em.createQuery("select area from Area area " +
                "where area.name = :name")
                .setParameter("name", city)
                .getSingleResult();
    }
}
