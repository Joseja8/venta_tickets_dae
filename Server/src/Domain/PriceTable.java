package Domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joseja on 10/21/16.
 */
public class PriceTable {

    ArrayList<PriceTableEntry> priceTable;

    public PriceTable() {
        this.priceTable =
                new ArrayList<>(Arrays.asList(new PriceTableEntry(), new PriceTableEntry(), new PriceTableEntry()));
    }

    public float getPrice(Event event, Zone zone) {
        PriceTableEntry entry = getEntry(event, zone);
        if (entry != null) {
            return entry.getPrice();
        } else {
            return -1;
        }
    }

    public boolean setPrice(Event event, Zone zone, float newPrice) {
        PriceTableEntry entry = getEntry(event, zone);
        if (entry != null) {
            entry.setPrice(newPrice);
            return true;
        } else {
            return false;
        }
    }

    private PriceTableEntry getEntry(Event event, Zone zone) {
        for (PriceTableEntry entry : priceTable) {
            if (entry.getEvent().equals(event) && entry.getZone().equals(zone.getId()))
                return entry;
        }
        return null;
    }
}
