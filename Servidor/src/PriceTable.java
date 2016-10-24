import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class PriceTable {

    static ArrayList<PriceTableEntry> priceTable = new ArrayList<>();

    public PriceTable() {
    }

    public static float getPrice(Event event, Zone zone) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                return entry.getPrice();
        }
        return -1;
    }

    public static void setPrice(Event event, Zone zone, float newPrice) {
        if (zoneExists(event, zone)) {
            for (PriceTableEntry entry : priceTable) {
                if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                    entry.setPrice(newPrice);
            }
        } else {
            priceTable.add(new PriceTableEntry(event, zone.getId(), newPrice));
        }
    }

    private static boolean zoneExists(Event event, Zone zone) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone))
                return true;
        }
        return false;
    }
}
