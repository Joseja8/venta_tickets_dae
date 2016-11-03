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

    enum Zones { A, B, C, D, E }

    enum EventTypes { Music, Theatre, Festival, Sport }

    Event getEvent(String name, LocalDate date, String city);
    ArrayList<Event> getEvents(String name);
    ArrayList<Event> getEvents(String name, String city);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type);
    ArrayList<Event> getEvents(LocalDate date, EventTypes type, String city);

    boolean setPrice(Event event, Zone zone, float price, String token);

    boolean createEvent(String name, EventTypes type, LocalDate startDate, LocalDate finishDate, Area area, String token);
    boolean createArea(String city, ArrayList<Zone> zones, String token);
    boolean createZone(Zones zone, int seats, String token);

    ArrayList<Area> getAreas();
    Area getArea(String city);
    Area getArea(int index);
    Zones[] getZones();
    EventTypes[] getEventTypes();
}
