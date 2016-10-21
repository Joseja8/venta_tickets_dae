/**
 * Created by joseja on 10/19/16.
 */
public class Zone {

    private Utils.Zones id;
    private Event event;
    private int seats;
    private float price;

    public Zone(Utils.Zones zone) {
        this.id = zone;
    }

    public Utils.Zones getId() {
        return id;
    }

    public void setId(Utils.Zones id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
