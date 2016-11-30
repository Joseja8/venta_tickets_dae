package Ticket;

import Event.Event;
import User.*;
import Zone.Zone;

import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public class TicketManagerImp implements TicketManager {

    private UserManager userManager;

    private TicketDao ticketDao;
    private UserDao userDao;

    @Override
    public List<Ticket> getTickets(String token) {
        if (userManager.isUser(token)) {
            return userDao.getTickets(token);
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    @Override  // TODO: Check that the event exits.
    public boolean buyTicket(Event event, Zone zone, String token) {
        if (userManager.isUser(token)) {
            User user = userDao.findByToken(token);
            Ticket ticket = new Ticket(event, zone);
            user.addTicket(ticket);
            userDao.update(user);
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

    public TicketDao getTicketDao() {
        return ticketDao;
    }

    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
