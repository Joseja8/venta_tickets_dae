import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("Servidor/applicationContext.xml");

        Test obj = (Test) context.getBean("test");

        obj.getMessage();
    }
}
