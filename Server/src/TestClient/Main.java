package TestClient;

import Domain.DBConnection;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            AbstractApplicationContext context =
                    new FileSystemXmlApplicationContext("Server/applicationContext.xml");
            context.registerShutdownHook();

            Menu menu = new Menu(context);
            menu.mainMenu();

            DBConnection DBConnection = (DBConnection) context.getBean("DBConnection");
            Statement statement = DBConnection.getConnection().createStatement();

        } catch(Exception e) {
            System.err.println("Context initialization error: " + e.getMessage());
            System.exit(0);
        }
    }
}
