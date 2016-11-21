package PriceTable;

import Event.Event;
import Event.EventManager;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by joseja on 10/21/16.
 */
@Entity
@Table(name="PRICES")
class PriceTableEntry implements Serializable {

    private int id;

    private Event event;

    private EventManager.Zones zoneID;
    private float price;

    public PriceTableEntry() {
        this.setEvent(new Event());
        this.setZoneID(EventManager.Zones.A);
        this.price = 0;
    }

    public PriceTableEntry(Event event, EventManager.Zones zoneID, float price) {
        this.setEvent(event);
        this.setZoneID(zoneID);
        this.price = price;
    }

    @Id
    @Column(name="price_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @OneToOne
    public Event getEvent() {
        return this.event;
    }

    public EventManager.Zones getZoneID() {
        return zoneID;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setZoneID(EventManager.Zones zoneID) {
        this.zoneID = zoneID;
    }
}
