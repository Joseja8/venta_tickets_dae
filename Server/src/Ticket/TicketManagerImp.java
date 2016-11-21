package Ticket;

import Event.Event;
import User.UserManager;
import Zone.Zone;

import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public class TicketManagerImp implements TicketManager {

    private UserManager userManager;

    @Override
    public List<Ticket> getTickets(String token) {
        if (userManager.isUser(token)) {
            return userManager.getUser(token).getTickets();
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    @Override  // TODO: Check that the event exits.
    public boolean buyTicket(Event event, Zone zone, String token) {
        if (userManager.isUser(token)) {
            Ticket ticket = new Ticket(event, zone);
            userManager.getUser(token).addTicket(ticket);
            return true;
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
