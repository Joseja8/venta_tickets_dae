package Ticket;

import Event.Event;
import Zone.Zone;
import PriceTable.PriceTable;

import javax.persistence.*;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class Ticket {

    private int id;

    private PriceTable priceTable;

    private Event event;

    private Zone zone;

    private float price;

    public Ticket() {
    }

    public Ticket(Event event, Zone zone) {
        this.setEvent(event);
        this.setZone(zone);
        //this.setPrice(getPriceTable().getPrice(event, zone));
    }

    @Id
    @Column(name="ticket_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    public Event getEvent() {
        return this.event;
    }

    @OneToOne
    public Zone getZone() {
        return zone;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        return "Ticket: " + getId() + ", Price: " + getPrice();
    }

    @Transient
    public PriceTable getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(PriceTable priceTable) {
        this.priceTable = priceTable;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
