package Domain;

import Interfaces.EventManager;

/**
 * Created by joseja on 10/21/16.
 */
public class PriceTableEntry {

    private Event event;
    private EventManager.Zones zoneID;
    private float price;

    public PriceTableEntry() {
        this.event = new Event();
        this.zoneID = EventManager.Zones.A;
        this.price = 0;
    }

    public PriceTableEntry(Event event, EventManager.Zones zoneID, float price) {
        this.event = event;
        this.zoneID = zoneID;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventManager.Zones getZone() {
        return zoneID;
    }

    public void setZone(EventManager.Zones zoneID) {
        this.zoneID = zoneID;
    }
}
