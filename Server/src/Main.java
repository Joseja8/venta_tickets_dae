import TestClient.Menu;
import Zone.Zone;
import Zone.ZoneDao;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("Server/applicationContext.xml");
        context.registerShutdownHook();

        // TODO: Fill tables.
        ZoneDao dao = (ZoneDao) context.getBean("zoneDao");
        dao.insert(new Zone());

        Menu menu = new Menu(context);
        menu.mainMenu();
    }
}
