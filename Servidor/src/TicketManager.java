import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface TicketManager {

    ArrayList<Ticket> getTickets(User user, String token);
    void buyTicket(User user, Event event, Zone zone, String token);
}
