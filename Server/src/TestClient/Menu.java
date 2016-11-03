package TestClient;

import Interfaces.EventManager;
import org.joda.time.LocalDate;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

/**
 * Created by joseja on 10/24/16.
 */
public class Menu {

    AbstractApplicationContext context;

    Interfaces.UserManager userManager;
    Interfaces.EventManager eventManager;
    Interfaces.TicketManager ticketMaganer;

    public Menu(AbstractApplicationContext context) {
        this.context = context;

        this.userManager = (Interfaces.UserManager) context.getBean("userManagerImp");
        this.eventManager = (Interfaces.EventManager) context.getBean("eventManagerImp");
        this.ticketMaganer = (Interfaces.TicketManager) context.getBean("ticketManagerImp");

        userManager.saveUser("admin", "admin");
    }

    public void mainMenu() {
        while (true) {
            MenuUtils.cleanConsole();
            System.out.println("PRINCIPAL MENU");

            System.out.print("\n");
            System.out.println("1.  Login");
            System.out.println("2.  Sign up");
            System.out.print("\n");
            System.out.print("Select an option (-1 to exit): ");
            int option = MenuUtils.getIntInput();

            MenuUtils.cleanConsole();

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private void login() {
        System.out.println("LOGIN");

        System.out.print("\n");
        System.out.print("Username: ");
        String username = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Password: ");
        String password = new Scanner(System.in).next();

        String token = userManager.getToken(username, password);

        MenuUtils.cleanConsole();

        if (token != null) {
            if(userManager.isAdmin(token)) {
                adminMenu(token);
            } else {
                userMenu(token);
            }
        } else {
            System.out.print("Wrong username/password");
            MenuUtils.waitSeconds(2);
        }

        MenuUtils.cleanConsole();
    }

    private void signUp() {
        System.out.println("SIGN UP");

        System.out.print("\n");
        System.out.print("Username: ");
        String username = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Password: ");
        String password = new Scanner(System.in).next();

        userManager.saveUser(username, password);

        MenuUtils.cleanConsole();

        System.out.print("User saved");
        MenuUtils.waitSeconds(2);

    }

    void userMenu(String token) {
        while (true) {
            System.out.println("USER MENU");

            System.out.print("\n");
            System.out.println("1.  Search events");
            System.out.println("2.  Buy tickets");
            System.out.println("3.  See owned tickets");
            System.out.print("\n");
            System.out.print("Select an option (-1 to main menu): ");
            int option = MenuUtils.getIntInput();

            MenuUtils.cleanConsole();

            switch (option) {
                case 1:
                    eventSearch(token);
                    break;
                case 2:
                    buyTicket(token);
                    break;
                case 3:
                    seeTickets(token);
                    break;
                default:
                    mainMenu();
            }
        }
    }

    private void eventSearch(String token) {
        while (true) {
            System.out.println("EVENT SEARCH");

            System.out.print("\n");
            System.out.println("1.  Search by name");
            System.out.println("2.  Search by name & city");
            System.out.println("3.  Search by date & type");
            System.out.println("4.  Search by date & type & city");
            System.out.print("\n");
            System.out.print("Select an option (-1 to user menu): ");
            int option = MenuUtils.getIntInput();

            MenuUtils.cleanConsole();

            switch (option) {
                case 1:
                    searchEventByName();
                    break;
                case 2:
                    searchEventByNameAndCity();
                    break;
                case 3:
                    searchEventByDateAndType();
                    break;
                case 4:
                    searchEventByDateAndTypeAndCity();
                    break;
                default:
                    userMenu(token);
            }
        }
    }

    private void searchEventByDateAndTypeAndCity() {
        System.out.println("SEARCH EVENT BY DATE, TYPE AND CITY");

        System.out.print("\n");
        System.out.print("Enter the date of the event: (-1 to cancel): ");
        LocalDate eventDate = LocalDate.parse(new Scanner(System.in).next());

        System.out.print("\n");
        System.out.print("Enter the type of the event: (-1 to cancel): ");
        EventManager.EventTypes eventType = selectEventType();

        System.out.print("\n");
        System.out.print("Enter the city of the event: (-1 to cancel): ");
        String eventCity = new Scanner(System.in).next();

        MenuUtils.cleanConsole();

        if (eventType != null) {
            System.out.println(eventManager.getEvents(eventDate, eventType, eventCity));
            MenuUtils.waitSeconds(5);
        } else {
            System.out.println("You must select an event type.");
            MenuUtils.waitSeconds(2);
        }

        MenuUtils.cleanConsole();
    }

    private EventManager.EventTypes selectEventType() {
        System.out.println("EVENT TYPE SELECTION");

        System.out.print("\n");
        System.out.println("1.  " + EventManager.EventTypes.Festival);
        System.out.println("2.  " + EventManager.EventTypes.Music);
        System.out.println("3.  " + EventManager.EventTypes.Sport);
        System.out.println("4.  " + EventManager.EventTypes.Theatre);
        System.out.print("\n");
        System.out.print("Select an option (-1 to search event by date, type and city): ");
        int option = MenuUtils.getIntInput();

        switch (option) {
            case 1:
                return EventManager.EventTypes.Festival;
            case 2:
                return EventManager.EventTypes.Music;
            case 3:
                return EventManager.EventTypes.Sport;
            case 4:
                return EventManager.EventTypes.Theatre;
            default:
                return null;
        }
    }

    private void searchEventByDateAndType() {
        System.out.println("SEARCH EVENT BY DATE AND TYPE");
        System.out.print("\n");
        System.out.print("Enter the date of the event: (-1 to cancel): ");
        LocalDate eventDate = LocalDate.parse(new Scanner(System.in).next());
        System.out.print("\n");
        System.out.print("Enter the type of the event: (-1 to cancel): ");
        EventManager.EventTypes eventType = selectEventType();

        MenuUtils.cleanConsole();

        if (eventType != null) {
            System.out.println(eventManager.getEvents(eventDate, eventType));
            MenuUtils.waitSeconds(5);
        } else {
            System.out.println("You must select an event type.");
            MenuUtils.waitSeconds(2);
        }

        MenuUtils.cleanConsole();
    }

    private void searchEventByNameAndCity() {
        System.out.println("SEARCH EVENT BY NAME AND CITY");

        System.out.print("\n");
        System.out.print("Enter the name of the event: (-1 to cancel): ");
        String eventName = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Enter the city of the event: (-1 to cancel): ");
        String eventCity = new Scanner(System.in).next();

        MenuUtils.cleanConsole();

        System.out.println(eventManager.getEvents(eventName, eventCity));
        MenuUtils.waitSeconds(5);

        MenuUtils.cleanConsole();
    }

    private void searchEventByName() {
        System.out.println("SEARCH EVENT BY NAME");
        System.out.print("\n");
        System.out.print("Enter the name of the event: (-1 to cancel): ");
        String eventName = new Scanner(System.in).next();

        MenuUtils.cleanConsole();

        System.out.println(eventManager.getEvents(eventName));
        MenuUtils.waitSeconds(5);

        MenuUtils.cleanConsole();
    }


    private boolean buyTicket(String token) {
        System.out.println("BUY TICKET");

        System.out.print("\n");
        System.out.print("Enter the name of the event: ");
        String eventName = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Enter the date of the event: ");
        LocalDate eventDate = LocalDate.parse(new Scanner(System.in).next());

        System.out.print("\n");
        System.out.print("Enter the city of the event: ");
        String eventCity = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Zones of the event");
        System.out.print("\n");
        if (eventManager.getEvent(eventName, eventDate, eventCity) == null) {
            MenuUtils.cleanConsole();
            System.out.println("Not a valid event");
            MenuUtils.waitSeconds(2);
            return false;
        }
        int numberOfZones = eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZones().size();
        for (int i = 1; i <= numberOfZones; ++i) {
            System.out.println(i + ".  " + eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZone(i-1));
        }
        System.out.print("\n");
        System.out.print("Enter the zone: ");
        System.out.print("\n");

        int eventZone = MenuUtils.getIntInput();

        if (eventZone > 0 && eventZone <= numberOfZones) {
            ticketMaganer.buyTicket(eventManager.getEvent(eventName, eventDate, eventCity),
                    eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZone(eventZone),
                    token);
            System.out.println("Transaction OK");
            MenuUtils.cleanConsole();
            MenuUtils.waitSeconds(2);
            return true;
        } else {
            MenuUtils.cleanConsole();
            System.out.println("Nota valid zone");
            MenuUtils.waitSeconds(2);
            MenuUtils.cleanConsole();
            return false;
        }
    }


    private void seeTickets(String token) {
        System.out.println(ticketMaganer.getTickets(token));
        MenuUtils.waitSeconds(5);
        MenuUtils.cleanConsole();
    }

    void adminMenu(String token) {
        while (true) {
            int option;
            System.out.println("ADMIN MENU");
            System.out.print("\n");
            System.out.println("1.  Add event");
            System.out.println("2.  Set ticket price");
            System.out.print("\n");
            System.out.print("Select an option (-1 to main menu): ");
            option = MenuUtils.getIntInput();

            MenuUtils.cleanConsole();

            switch (option) {
                case 1:
                    addEvent(token);
                    break;
                case 2:
                    setTicketPrice(token);
                    break;
                default:
                    mainMenu();
            }
        }
    }

    private boolean setTicketPrice(String token) {
        System.out.println("SET TICKET PRICE");

        System.out.print("\n");
        System.out.print("Enter the name of the event: ");
        String eventName = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Enter the date of the event: ");
        LocalDate eventDate = LocalDate.parse(new Scanner(System.in).next());

        System.out.print("\n");
        System.out.print("Enter the city of the event: ");
        String eventCity = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Zones of the event");
        System.out.print("\n");
        if (eventManager.getEvent(eventName, eventDate, eventCity) == null) {
            MenuUtils.cleanConsole();
            System.out.println("Not a valid event");
            MenuUtils.waitSeconds(2);
            return false;
        }
        int numberOfZones = eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZones().size();
        for (int i = 1; i <= numberOfZones; ++i) {
            System.out.println(i + ".  " + eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZone(i-1));
        }
        System.out.print("\n");
        System.out.print("Enter the zone: ");
        System.out.print("\n");

        int eventZone = MenuUtils.getIntInput();

        System.out.print("\n");
        System.out.print("Enter the new price: ");
        System.out.print("\n");

        float newPrice = MenuUtils.getFloatInput();

        if (eventZone > 0 && eventZone <= numberOfZones) {

            boolean transaction = eventManager.setPrice(eventManager.getEvent(eventName, eventDate, eventCity),
                    eventManager.getEvent(eventName, eventDate, eventCity).getArea().getZone(eventZone),
                    newPrice,
                    token);
            if (transaction) {
                System.out.println("Transaction OK");
                MenuUtils.waitSeconds(2);
            } else {
                System.out.println("An error ocurred");
                MenuUtils.waitSeconds(2);
            }
            MenuUtils.cleanConsole();
            return true;
        } else {
            MenuUtils.cleanConsole();
            System.out.println("Nota valid zone");
            MenuUtils.waitSeconds(2);
            MenuUtils.cleanConsole();
            return false;
        }
    }

    private void addEvent(String token) {
        System.out.println("CREATE EVENT");

        System.out.print("\n");
        System.out.print("Enter the name of the event: (-1 to cancel): ");
        String eventName = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Enter the start date of the event: (-1 to cancel): ");
        LocalDate eventStartDate = LocalDate.parse(new Scanner(System.in).next());

        System.out.print("\n");
        System.out.print("Enter the finish date of the event: (-1 to cancel): ");
        LocalDate eventFinishDate = LocalDate.parse(new Scanner(System.in).next());

        System.out.print("\n");
        System.out.print("Enter the type of the event: (-1 to cancel): ");
        EventManager.EventTypes eventType = selectEventType();

        System.out.print("\n");
        System.out.print("Enter the city of the event: (-1 to cancel): ");
        String eventCity = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Enter the Area of the event: (-1 to cancel): ");
        String eventArea = selectArea();

        MenuUtils.cleanConsole();

        if (eventType != null && eventName != null) {
            System.out.println(eventManager.createEvent(eventName, eventType, eventStartDate,
                    eventFinishDate, eventManager.getArea(eventCity), token));
            MenuUtils.waitSeconds(5);
        } else {
            System.out.println("Wrong data");
            MenuUtils.waitSeconds(2);
        }

        MenuUtils.cleanConsole();
    }

    private String selectArea() {
        System.out.println("EVENT AREA SELECTION");

        for (int i = 0; i <= eventManager.getAreas().size(); ++i) {
            System.out.println("Area:  " + eventManager.getArea(i));
        }
        System.out.print("\n");
        System.out.print("Enter the area: ");
        String area = new Scanner(System.in).next();

        if (area != null) {
            return area;
        } else {
            System.out.println("Area not found");
            return null;
        }
    }

}
