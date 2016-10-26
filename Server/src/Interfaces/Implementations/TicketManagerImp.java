package Interfaces.Implementations;

import Domain.Event;
import Domain.Ticket;
import Domain.Zone;
import Interfaces.TicketManager;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class TicketManagerImp implements TicketManager {

    private Interfaces.UserManager userManager;

    @Override
    public ArrayList<Ticket> getTickets(String token) {
        if (userManager.getUser(token) != null) {
            return userManager.getUser(token).getTickets();
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    @Override  // TODO: Check that the event exits.
    public void buyTicket(Event event, Zone zone, String token) {
        if (userManager.getUser(token) != null) {
            Ticket ticket = new Ticket(event, zone);
            userManager.getUser(token).addTicket(ticket);
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    public Interfaces.UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(Interfaces.UserManager userManager) {
        this.userManager = userManager;
    }
}
