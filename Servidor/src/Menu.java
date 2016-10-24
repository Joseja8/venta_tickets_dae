import java.util.Scanner;

/**
 * Created by joseja on 10/24/16.
 */
public class Menu {

    public void mainMenu() {
        while (true) {
            int option;
            System.out.println("PRINCIPAL MENU");
            System.out.print("\n");
            System.out.println("1.  Login");
            System.out.println("2.  Sign up");
            System.out.print("\n");
            System.out.print("Select an option (-1 to cancel): ");
            option = MenuUtils.getIntInput();

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
        System.out.print("Username (-1 to cancel): ");
        String username = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Password (-1 to cancel): ");
        String password = new Scanner(System.in).next();

        String token = UserManagerImp.getToken(username, password);

        MenuUtils.cleanConsole();

        if (token != null) {
            if(UserManagerImp.isAdmin(token)) {
                adminMenu();
            } else {
                userMenu();
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
        System.out.print("Username (-1 to cancel): ");
        String username = new Scanner(System.in).next();

        System.out.print("\n");
        System.out.print("Password (-1 to cancel): ");
        String password = new Scanner(System.in).next();

        UserManagerImp.saveUser(username, password);

        MenuUtils.cleanConsole();

        System.out.print("User saved");
        MenuUtils.waitSeconds(2);

    }

    void userMenu() {
        while (true) {
            int option;
            System.out.println("USER MENU");
            System.out.print("\n");
            System.out.println("1.  Search events");
            System.out.println("2.  Buy tickets");
            System.out.println("3.  See owned tickets");
            System.out.print("\n");
            System.out.print("Select an option (-1 to main menu): ");
            option = MenuUtils.getIntInput();

            MenuUtils.cleanConsole();

            switch (option) {
                case 1:
                    eventSearch();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    seeTickets();
                    break;
                default:
                    mainMenu();
            }
        }
    }

    private void eventSearch() {
    }


    private void buyTicket() {
    }


    private void seeTickets() {
    }

    void adminMenu() {
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
                    addEvent();
                    break;
                case 2:
                    setTicketPrice();
                    break;
                default:
                    mainMenu();
            }
        }
    }

    private void setTicketPrice() {

    }

    private void addEvent() {

    }

}
