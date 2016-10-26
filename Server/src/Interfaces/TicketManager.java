package Interfaces;

import Domain.Event;
import Domain.Ticket;
import Domain.Zone;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface TicketManager {

    ArrayList<Ticket> getTickets(String token);
    void buyTicket(Event event, Zone zone, String token);
}
