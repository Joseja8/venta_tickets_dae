package Event;

import org.joda.time.LocalDate;
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
public class EventDao {

    @PersistenceContext
    EntityManager em;

    public Event findbyNameAndDateAndCity(String name, LocalDate date, String city) {
        return ((Event)em.createQuery("select event from Event event " +
                "where event.name = :name " +
                "and :date between event.startDate and event.finishDate " +
                "and event.area.name = :city")
                .setParameter("name", name)
                .setParameter("date", date.toString())
                .setParameter("city", city)
                .getSingleResult());
    }

    public List<Event> findAll() {return em.createQuery("select d from Event d").getResultList();}

    public List<Event> findByName(String name) {
        return em.createQuery("select event from Event event " +
                "where event.name = :name")
                .setParameter("name", name)
                .getResultList();
    }
    public List<Event> findByNameAndCity(String name, String city) {
        return em.createQuery("select event from Event event " +
                "where event.name = :name " +
                "and event.area = :city")
                .setParameter("name", name)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Event> findByDateAndType(LocalDate date, EventManager.EventType type) {
        return em.createQuery("select event from Event event " +
                "where :date between event.startDate and event.finishDate " +
                "and event.eventType = :type")
                .setParameter("date", date.toString())
                .setParameter("type", type)
                .getResultList();
    }

    public List<Event> findByDateAndCity(LocalDate date, String city) {
        return em.createQuery("select event from Event event " +
                "where :date between event.startDate and event.finishDate " +
                "and event.area = :city")
                .setParameter("date", date.toString())
                .setParameter("city", city)
                .getResultList();
    }

    public List<Event> findByDateAndTypeAndCity(LocalDate date, EventManager.EventType type, String city) {
        return em.createQuery("select event from Event event " +
                "where :date between event.startDate and event.finishDate " +
                "and event.eventType = :type " +
                "and event.area = :city")
                .setParameter("date", date.toString())
                .setParameter("type", type)
                .setParameter("city", city)
                .getResultList();
    }

    public void insert(Event event) {
        em.persist(event);
        em.flush();
    }
}
