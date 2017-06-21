package Event;

import Area.Area;
import Zone.Zone;
import org.joda.time.LocalDate;

import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public interface EventManager {

    enum ZoneType { A, B, C, D, E }
    ZoneType[] getZoneTypes();

    enum EventType { Music, Theatre, Festival, Sport }
    EventManager.EventType[] getEventTypes();

    Event getEvent(String name, LocalDate date, String city);
    List<Event> getEvents();
    List<Event> getEvents(String name);
    List<Event> getEvents(String name, String city);
    List<Event> getEvents(LocalDate date, EventType type);
    List<Event> getEvents(LocalDate date, EventType type, String city);

    List<Area> getAreas();
    Area getArea(String name);

    boolean addPrice(Event event, Zone zone, float price, String token);
    boolean setPrice(Event event, Zone zone, float price, String token);

    boolean createEvent(Event event, String token);
    boolean createArea(Area area, String token);
    Zone createZone(ZoneType zone, int seats, String token);
}
