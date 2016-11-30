import Area.Area;
import Area.AreaDao;
import Event.Event;
import Event.EventDao;
import Event.EventManager;
import TestClient.Menu;
import User.User;
import User.UserDao;
import Zone.Zone;
import Zone.ZoneDao;
import org.joda.time.LocalDate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("Server/applicationContext.xml");
        context.registerShutdownHook();

        ZoneDao zoneDao = (ZoneDao) context.getBean("zoneDao");
        Zone testZone = new Zone(EventManager.Zones.A,1);
        Zone zone1 = new Zone(EventManager.Zones.A,500);
        Zone zone2 = new Zone(EventManager.Zones.C,150);
        Zone zone3 = new Zone(EventManager.Zones.B,50);
        Zone zone4 = new Zone(EventManager.Zones.E,100);
        Zone zone5 = new Zone(EventManager.Zones.D,230);
        zoneDao.insert(testZone);
        zoneDao.insert(zone1);
        zoneDao.insert(zone2);
        zoneDao.insert(zone3);
        zoneDao.insert(zone4);
        zoneDao.insert(zone5);
        List<Zone> testZones = Arrays.asList(testZone);
        List<Zone> zoneList1 = Arrays.asList(zone1, zone2, zone3);
        List<Zone> zoneList2 = Arrays.asList(zone2, zone4, zone5);
        List<Zone> zoneList3 = Arrays.asList(zone4, zone5);

        AreaDao areaDao = (AreaDao) context.getBean("areaDao");
        Area testArea = new Area("test", testZones);
        Area area1 = new Area("Malaga", zoneList1);
        Area area2 = new Area("Barcelona", zoneList3);
        Area area3 = new Area("Madrid", zoneList3);
        Area area4 = new Area("Zaragoza", zoneList1);
        Area area5 = new Area("Jaen", zoneList2);
        areaDao.insert(testArea);
        areaDao.insert(area1);
        areaDao.insert(area2);
        areaDao.insert(area3);
        areaDao.insert(area4);
        areaDao.insert(area5);

        EventDao dao = (EventDao) context.getBean("eventDao");
        String defaultDate = LocalDate.parse("2016-01-01").toString();
        Event testEvent = new Event("test", EventManager.EventTypes.Festival, defaultDate, defaultDate, testArea);
        Event event1 = new Event("Leyendas del Rock", EventManager.EventTypes.Festival, defaultDate, defaultDate, area1);
        Event event2 = new Event("La bella y la bestia", EventManager.EventTypes.Theatre, defaultDate, defaultDate, area3);
        Event event3 = new Event("Partido Real Madrid - Atletico Madrid",EventManager.EventTypes.Sport, defaultDate, defaultDate, area2);
        Event event4 = new Event("Rey Leon",EventManager.EventTypes.Theatre, defaultDate, defaultDate, area5);
        Event event5 = new Event("Baloncesto",EventManager.EventTypes.Sport, defaultDate, defaultDate, area4);
        dao.insert(testEvent);
        dao.insert(event1);
        dao.insert(event2);
        dao.insert(event3);
        dao.insert(event4);
        dao.insert(event5);

        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.insert(new User("admin","admin", UUID.nameUUIDFromBytes(("admin" + "admin").getBytes()).toString()));
        userDao.insert(new User("test","test", UUID.nameUUIDFromBytes(("test" + "test").getBytes()).toString()));
        userDao.insert(new User("jose","jose", UUID.nameUUIDFromBytes(("jose" + "jose").getBytes()).toString()));
        userDao.insert(new User("maria","maria", UUID.nameUUIDFromBytes(("maria" + "maria").getBytes()).toString()));
        userDao.insert(new User("juan","juan", UUID.nameUUIDFromBytes(("juan" + "juan").getBytes()).toString()));


        Menu menu = new Menu(context);
        menu.mainMenu();
    }
}
