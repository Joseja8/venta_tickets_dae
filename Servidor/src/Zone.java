/**
 * Created by joseja on 10/19/16.
 */
public class Zone {

    private Utils.Zones id;
    private int seats;
    private float price;

    public Zone(Utils.Zones zone, int seats) {
        this.id = zone;
        this.seats = seats;
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
}
