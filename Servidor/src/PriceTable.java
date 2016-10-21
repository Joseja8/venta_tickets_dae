import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class PriceTable {

    static ArrayList<PriceTableEntry> priceTable;

    public static float getPrice(Event event, Utils.Zones zone) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                return entry.getPrice();
        }
        return -1;
    }

    public static void setPrice(Event event, Utils.Zones zone, float newPrice) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                entry.setPrice(newPrice);
        }
    }

    public static int getBoughtSeats(Event event, Utils.Zones zone) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                return entry.getBoughtSeats();
        }
        return -1;
    }
}
