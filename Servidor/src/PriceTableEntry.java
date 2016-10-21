/**
 * Created by joseja on 10/21/16.
 */
public class PriceTableEntry {

    private Zone zone;
    private int boughtSeats;

    public float getPrice() {
        return zone.getPrice();
    }

    public void setPrice(float price) {
        this.zone.setPrice(price);
    }

    public int getBoughtSeats() {
        return boughtSeats;
    }

    public void setBoughtSeats(int boughtSeats) {
        this.boughtSeats = boughtSeats;
    }

    public Event getEvent() {
        return zone.getEvent();
    }

    public void setEvent(Event event) {
        this.zone.setEvent(event);
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
