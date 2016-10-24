import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class TicketManagerImp implements TicketManager {
    @Override
    public ArrayList<Ticket> getTickets(User user, String token) {
        if (UserManagerImp.getUser(token).equals(user)) {
            return user.getTickets();
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }

    @Override
    public void buyTicket(User user, Event event, Zone zone, String token) {
        if (UserManagerImp.getUser(token).equals(user)) {
            user.addTicket(new Ticket(event, zone));
        } else {
            throw new IllegalStateException("Invalid token");
        }
    }
}
