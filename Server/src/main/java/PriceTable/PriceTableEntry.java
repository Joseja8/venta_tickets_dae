package PriceTable;

import Event.*;

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

    private EventManager.ZoneType zoneType;
    private float price;

    public PriceTableEntry() {
    }

    public PriceTableEntry(Event event, EventManager.ZoneType zoneType, float price) {
        this.setEvent(event);
        this.setZoneType(zoneType);
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

    public EventManager.ZoneType getZoneType() {
        return zoneType;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setZoneType(EventManager.ZoneType zoneID) {
        this.zoneType = zoneID;
    }
}
