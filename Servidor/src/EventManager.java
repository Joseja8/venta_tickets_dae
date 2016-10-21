import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joseja on 10/21/16.
 */
public interface EventManager {

    ArrayList<Event> getEvents(String name);
    ArrayList<Event> getEvents(String name, String city);
    ArrayList<Event> getEvents(Date date, Utils.EventType type);
    ArrayList<Event> getEvents(Date date, Utils.EventType type, String city);
    Event getEvent(String name, Date date, String city);
}
