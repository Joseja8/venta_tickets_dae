package Event;

import Area.Area;
import PriceTable.PriceTableImp;
import User.UserManager;
import Zone.Zone;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public class EventManagerImp implements EventManager {

    private UserManager userManager;

    private PriceTable.PriceTableImp priceTable;

    private EventDao eventDao;

    private ArrayList<Event> events;
    private ArrayList<Area> areas;

    public EventManagerImp() {
        this.events = new ArrayList<>(Arrays.asList(new Event()));

        Zone zone1 = new Zone(Zones.A, 100);
        Zone zone2 = new Zone(Zones.B, 200);
        Zone zone3 = new Zone(Zones.C, 300);
        Zone zone4 = new Zone(Zones.D, 400);
        Zone zone5 = new Zone(Zones.E, 500);

        Area area1 = new Area("madrid", new ArrayList<>(Arrays.asList(zone1, zone2)));
        Area area2 = new Area("barcelona", new ArrayList<>(Arrays.asList(zone1, zone2, zone3)));
        Area area3 = new Area("malaga", new ArrayList<>(Arrays.asList(zone1, zone4)));
        Area area4 = new Area("sevilla", new ArrayList<>(Arrays.asList(zone2)));

        this.areas = new ArrayList<>(Arrays.asList(area1, area2, area3, area4));
    }

    @Override
    public List<Event> getEvents() {
        return eventDao.findAll();
    }

    @Override
    public List<Event> getEvents(String name) {
        return eventDao.findByName(name);
    }

    @Override
    public List<Event> getEvents(String name, String city) {
        return eventDao.findByNameAndCity(name, city);
    }

    @Override
    public List<Event> getEvents(LocalDate date, EventTypes type) {
        return eventDao.findByDateAndType(date, type);
    }

    @Override
    public List<Event> getEvents(LocalDate date, EventTypes type, String city) {
        return eventDao.findByDateAndTypeAndCity(date, type, city);
    }

    @Override
    public Event getEvent(String name, LocalDate date, String city) {
        return eventDao.findbyNameAndDateAndCity(name, date, city);
    }

    @Override
    public boolean isValidEvent(String name, LocalDate date, String city) {
        boolean isValid = false;
        for (Event event : events) {
            boolean sameName = event.getName().equals(name);
            boolean betweenDate = date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate());
            boolean sameDate = date.equals(event.getStartDate()) || date.equals(event.getFinishDate());
            boolean sameCity = event.getArea().getName().equals(city);
            if (sameName && (betweenDate || sameDate) && sameCity) {
                isValid = true;
            }
        }
        return isValid;
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
    public boolean createEvent(Event event, String token) {
        if (userManager.isAdmin(token)) {
            events.add(event);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean createArea(Area area, String token) {
        if (userManager.isAdmin(token)) {
            areas.add(area);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Zone createZone(Zones zone, int seats, String token) {
        if (userManager.isAdmin(token)) {
            Zone newZone = new Zone(zone, seats);
            return newZone;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Area> getAreas() {
        return areas;
    }

    @Override
    public Area getArea(String city) {
        for (Area area : areas) {
            if (area.getName().equals(area)) {
                return area;
            }
        }
        return null;
    }

    @Override
    public Area getArea(int index) {
        if (index >= 0 && index < areas.size()) {
            return areas.get(index);
        } else {
            return null;
        }
    }

    @Override
    public Zones[] getZones() {
        return Zones.values();
    }

    @Override
    public EventTypes[] getEventTypes() {
        return EventTypes.values();
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public PriceTableImp getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(PriceTableImp priceTable) {
        this.priceTable = priceTable;
    }

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
