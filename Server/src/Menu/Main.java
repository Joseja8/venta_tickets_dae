package Menu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new FileSystemXmlApplicationContext("Server/applicationContext.xml");

        Menu menu = new Menu(context);
        menu.mainMenu();


        Domain.Area area = (Domain.Area) context.getBean("area");

//        Domain.Utils.showEventTypes();
//        Domain.Utils.showZones();
//
//        Domain.Zone zone1 = new Domain.Zone(Domain.Utils.Zones.A, 100);
//
//        Domain.Area area1 = new Domain.Area("Madrid");
//        area1.addZone(zone1);
//
//        Domain.Event event1 = new Domain.Event("Download", Domain.Utils.EventTypes.Festival, new LocalDate("2010-04-28"), new LocalDate("2010-04-28"), area1);
//
//        Domain.PriceTable.setPrice(event1, event1.getArea().getZones().get(0), 100);
//
//        System.out.println(event1.getArea().getZones().get(0).getSeats());
//        event1.getArea().getZones().get(0).buySeat();
//        event1.getArea().getZones().get(0).buySeat();
//        event1.getArea().getZones().get(0).buySeat();
//        System.out.println(event1.getArea().getZones().get(0).getFreeSeats());
//
//        Domain.User user1 = new Domain.User("pepe", "12345");
//        Interfaces.Implementations.UserManagerImp.saveUser(user1.getUsername(), user1.getPassword());
//        //user1.addTicket();
//        System.out.println(Interfaces.Implementations.UserManagerImp.getToken(user1.getUsername(), user1.getPassword()));
//        System.out.println(Interfaces.Implementations.UserManagerImp.getUser("e30f5c92-a86a-3abb-887c-4bc5504b308d").getUsername());
    }
}
