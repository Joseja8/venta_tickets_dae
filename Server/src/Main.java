import TestClient.Menu;
import Zone.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("Server/applicationContext.xml");
        context.registerShutdownHook();

        //DBConnection DBConnection = (DBConnection) context.getBean("DBConnection");
        //Connection statement = DBConnection.getConnection();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ServerPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Zone());
        entityManager.persist(new Zone());
        entityManager.persist(new Zone());
        entityManager.getTransaction().commit();
        entityManager.close();
        // TODO: Fill tables.

        Menu menu = new Menu(context);
        menu.mainMenu();
    }
}
