import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("Servidor/applicationContext.xml");

        UserManagerImp.saveUser("jose", "jose");
        UserManagerImp.saveUser("maria", "maria");
        UserManagerImp.saveUser("admin", "admin");


        Menu menu = new Menu();
        menu.mainMenu();


        //Area area = (Area) context.getBean("area");

//        Utils.showEventTypes();
//        Utils.showZones();
//
//        Zone zone1 = new Zone(Utils.Zones.A, 100);
//
//        Area area1 = new Area("Madrid");
//        area1.addZone(zone1);
//
//        Event event1 = new Event("Download", Utils.EventTypes.Festival, new LocalDate("2010-04-28"), new LocalDate("2010-04-28"), area1);
//
//        PriceTable.setPrice(event1, event1.getArea().getZones().get(0), 100);
//
//        System.out.println(event1.getArea().getZones().get(0).getSeats());
//        event1.getArea().getZones().get(0).buySeat();
//        event1.getArea().getZones().get(0).buySeat();
//        event1.getArea().getZones().get(0).buySeat();
//        System.out.println(event1.getArea().getZones().get(0).getFreeSeats());
//
//        User user1 = new User("pepe", "12345");
//        UserManagerImp.saveUser(user1.getUsername(), user1.getPassword());
//        //user1.addTicket();  // TODO: Use TicketManager instead.
//        System.out.println(UserManagerImp.getToken(user1.getUsername(), user1.getPassword()));
//        System.out.println(UserManagerImp.getUser("e30f5c92-a86a-3abb-887c-4bc5504b308d").getUsername());
    }
}
