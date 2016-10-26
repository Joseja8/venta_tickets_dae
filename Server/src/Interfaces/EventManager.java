package Interfaces;

import Domain.Area;
import Domain.Event;
import Domain.Zone;
import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public interface EventManager {

    enum Zones {
        A, B, C, D, E
    }

    enum EventTypes {
        Music, Theatre, Festival, Sport
    }

    ArrayList<Event> getEvents(String name);
    ArrayList<Event> getEvents(String name, String city);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type, String city);
    Event getEvent(String name, LocalDate date, String city);
    boolean setPrice(Event event, Zone zone, float price, String token);
    ArrayList<Area> getAreas();
    Zones[] getZones();
    EventTypes[] getEventTypes();
}
