/**
 * Created by joseja on 10/21/16.
 */
public class PriceTableEntry {

    private Event event;
    private Utils.Zones zoneID;
    private float price;

    public PriceTableEntry(Event event, Utils.Zones zoneID, float price) {
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

    public Utils.Zones getZone() {
        return zoneID;
    }

    public void setZone(Utils.Zones zoneID) {
        this.zoneID = zoneID;
    }
}
