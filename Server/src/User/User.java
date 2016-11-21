package User;

import Ticket.Ticket;

import java.util.List;

/**
 * Created by joseja on 11/3/16.
 */
public interface User {

    int getId();
    List<Ticket> getTickets();
    String getUsername();
    String getPassword();
}
