import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface TicketManager {

    ArrayList<Ticket> getTickets(User user);
    void addTicket(User user, Event event, Utils.Zones zone);
}
