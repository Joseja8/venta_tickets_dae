package Ticket;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by joseja on 11/21/16.
 */
@Repository
@Transactional
public class TicketDao {

    @PersistenceContext
    EntityManager em;

    public Ticket find(int id) {
        return em.find(Ticket.class, id);
    }

    public void insert(Ticket ticket) {
        em.persist(ticket);
        em.flush();
    }
}
