package Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by joseja on 10/19/16.
 */
public class Ticket {

    @Autowired
    @Qualifier("priceTable")
    private PriceTable priceTable;

    private int id;
    private Event event;
    private Zone zone;
    private float price;

    public Ticket() {
        this.id = -1;
        this.event = new Event();
        this.zone = new Zone();
    }

    public Ticket(Event event, Zone zone) {
        this.id = -1;
        this.event = event;
        this.zone = zone;
        this.price = 0;
        update();
    }

    // TODO: Ticket id.
    public int getId() {
        return id;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void update() {
        this.price = priceTable.getPrice(event, zone);
    }

    public String toString() {
        return "Ticket: " + id + ", Price: " + price;
    }

    public PriceTable getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(PriceTable priceTable) {
        this.priceTable = priceTable;
    }
}
