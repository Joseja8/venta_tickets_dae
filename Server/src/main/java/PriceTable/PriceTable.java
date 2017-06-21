package PriceTable;

import Event.Event;
import Zone.Zone;

import java.util.List;

/**
 * Created by joseja on 11/3/16.
 */
public interface PriceTable {

    int getId();
    float getPrice(Event event, Zone zone);
    List<PriceTableEntry> getPrices();
    void addEntry(Event event, Zone zone, float price);
}
