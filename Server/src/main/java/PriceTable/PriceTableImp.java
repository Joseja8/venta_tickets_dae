package PriceTable;

import Event.Event;
import Zone.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joseja on 10/21/16.
 */
public class PriceTableImp implements PriceTable {

    private int id;

    private List<PriceTableEntry> prices;

    public PriceTableImp() {
        this.prices = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public List<PriceTableEntry> getPrices() {
        return prices;
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
            entry = new PriceTableEntry(event, zone.getType(), newPrice);
            return true;
        } else {
            return false;
        }
    }

    private PriceTableEntry getEntry(Event event, Zone zone) {
        for (PriceTableEntry entry : getPrices()) {
            if (entry.getEvent().equals(event) && entry.getZoneType().equals(zone.getType()))
                return entry;
        }
        return null;
    }

    public void addEntry(Event event, Zone zone, float price) {
        PriceTableEntry newEntry = new PriceTableEntry(event,zone.getType(), price);
        prices.add(newEntry);
    }
}
