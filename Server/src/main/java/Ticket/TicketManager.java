package Ticket;

import Event.Event;
import Zone.Zone;

import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public interface TicketManager {

    List<Ticket> getTickets(String token);
    boolean buyTicket(Event event, Zone zone, String token);
}
