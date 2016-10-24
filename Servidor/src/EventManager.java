import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface EventManager {

    ArrayList<Event> getEvents(String name);
    ArrayList<Event> getEvents(String name, String city);
    ArrayList<Event> getEvents(LocalDate date, Utils.EventTypes type);
    ArrayList<Event> getEvents(LocalDate date, Utils.EventTypes type, String city);
    Event getEvent(String name, LocalDate date, String city);
    ArrayList<Area> getAreas();
}
