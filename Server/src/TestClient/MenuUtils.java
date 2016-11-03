package TestClient;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by joseja on 10/24/16.
 */
public class MenuUtils {

    public static void cleanConsole() {
        for (int i = 0; i < 80; i++) {
            System.out.print("\n");
        }
    }

    public static int getIntInput() {
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextInt()) {
            return reader.nextInt();
        }
        return -1;
    }

    public static long getLongInput() {
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextLong()) {
            return reader.nextLong();
        }
        return -1;
    }

    public static long getFloatInput() {
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextFloat()) {
            return reader.nextLong();
        }
        return -1;
    }

    public static void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
