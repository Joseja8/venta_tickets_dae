package Interfaces.Implementations;

import Domain.Area;
import Domain.Event;
import Domain.PriceTable;
import Domain.Zone;
import Interfaces.EventManager;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joseja on 10/21/16.
 */
public class EventManagerImp implements EventManager {

    private Interfaces.UserManager userManager;

    private PriceTable priceTable;

    private ArrayList<Event> events;
    private ArrayList<Area> areas;

    public EventManagerImp() {
        this.events = new ArrayList<>(Arrays.asList(new Event(), new Event(), new Event()));
        this.areas = new ArrayList<>(Arrays.asList(new Area(), new Area(), new Area()));
    }

    @Override
    public ArrayList<Event> getEvents(String name) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getName().equals(name))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(String name, String city) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getName().equals(name) && event.getArea().getCity().equals(city))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(LocalDate date, EventTypes type) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventType().equals(type) && date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate()))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(LocalDate date, EventTypes type, String city) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventType().equals(type) && date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate()) && event.getArea().getCity().equals(city))
                results.add(event);
        return results;
    }

    @Override
    public Event getEvent(String name, LocalDate date, String city) {
        Event result = null;
        for (Event event : events) {
            boolean sameName = event.getName().equals(name);
            boolean betweenDate = date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate());
            boolean sameDate = date.equals(event.getStartDate()) || date.equals(event.getFinishDate());
            boolean sameCity = event.getArea().getCity().equals(city);
            if (sameName && (betweenDate || sameDate) && sameCity) {
                result = event;
            }
        }
        return result;
    }

    @Override
    public boolean setPrice(Event event, Zone zone, float price, String token) {
        if (userManager.isAdmin(token)) {
            priceTable.setPrice(event, zone, price);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Area> getAreas() {
        return areas;
    }

    @Override
    public Zones[] getZones() {
        return Zones.values();
    }

    @Override
    public EventTypes[] getEventTypes() {
        return EventTypes.values();
    }

    public Interfaces.UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(Interfaces.UserManager userManager) {
        this.userManager = userManager;
    }

    public PriceTable getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(PriceTable priceTable) {
        this.priceTable = priceTable;
    }
}
