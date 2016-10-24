/**
 * Created by joseja on 10/19/16.
 */
public class Utils {

    public enum Zones {
        A, B, C, D, E
    }
    Zones pepe;

    public enum EventTypes {
        Music, Theatre, Festival, Sport
    }

    public static void showZones() {
        for (Zones zone : Zones.values()) {
            System.out.print(zone + " ");
        }
        System.out.println();
    }

    public static void showEventTypes() {
        for (EventTypes eventType : EventTypes.values()) {
            System.out.print(eventType + " ");
        }
        System.out.println();
    }
}
