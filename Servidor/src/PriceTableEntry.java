/**
 * Created by joseja on 10/21/16.
 */
public class PriceTableEntry {

    private Event event;
    private Utils.Zones zoneID;
    private float price;
    private int boughtSeats;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBoughtSeats() {
        return boughtSeats;
    }

    public void setBoughtSeats(int boughtSeats) {
        this.boughtSeats = boughtSeats;
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
