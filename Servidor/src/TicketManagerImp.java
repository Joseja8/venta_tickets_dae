import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class TicketManagerImp implements TicketManager {
    @Override
    public ArrayList<Ticket> getTickets(User user) {
        return user.getTickets();
    }

    @Override
    public void addTicket(User user, Event event, Utils.Zones zone) {
        user.addTicket(new Ticket(event, zone));
    }
}
