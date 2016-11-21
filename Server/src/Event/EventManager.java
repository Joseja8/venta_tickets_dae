package Event;

import Area.Area;
import Zone.Zone;
import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface EventManager {

    enum Zones { A, B, C, D, E }

    Zones[] getZones();

    enum EventTypes { Music, Theatre, Festival, Sport }

    EventTypes[] getEventTypes();

    Event getEvent(String name, LocalDate date, String city);
    ArrayList<Event> getEvents();
    ArrayList<Event> getEvents(String name);
    ArrayList<Event> getEvents(String name, String city);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type, String city);
    boolean isValidEvent(String name, LocalDate date, String city);

    Area getArea(String name);
    Area getArea(int index);
    ArrayList<Area> getAreas();

    boolean setPrice(Event event, Zone zone, float price, String token);

    boolean createEvent(Event event, String token);
    boolean createArea(Area area, String token);
    Zone createZone(Zones zone, int seats, String token);
}
