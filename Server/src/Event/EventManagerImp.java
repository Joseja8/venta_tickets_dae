package Event;

import Area.Area;
import Area.AreaDao;
import PriceTable.PriceTableImp;
import User.UserManager;
import Zone.Zone;
import org.joda.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
@Transactional
public class EventManagerImp implements EventManager {

    private UserManager userManager;

    private PriceTable.PriceTableImp priceTable;

    private EventDao eventDao;
    private AreaDao areaDao;

    public EventManagerImp() {
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
            eventDao.insert(event);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean createArea(Area area, String token) {
        if (userManager.isAdmin(token)) {
            areaDao.insert(area);
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
    public List<Area> getAreas() {
        return areaDao.findAll();
    }

    @Override
    public Area getArea(String city) {
        return areaDao.findByCity(city);
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

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
}
