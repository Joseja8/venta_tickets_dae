import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("Servidor/applicationContext.xml");

        //Area area = (Area) context.getBean("area");

        Utils.showEventTypes();
        Utils.showZones();

        Zone zone1 = new Zone(Utils.Zones.A, 100);

        Area area1 = new Area("Madrid");
        area1.addZone(zone1);

        Event event = new Event("Download", Utils.EventTypes.Festival, new LocalDate("2010-04-28"), new LocalDate("2010-04-28"), area1);

        User pepe = new User("pepe", "12345");
    }
}
