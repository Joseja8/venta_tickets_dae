/**
 * Created by joseja on 10/19/16.
 */
public class Zone {

    private Utils.Zones id;
    private int seats;
    float price;

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

    public float getPrice() {
        // TODO: implementar busqueda en tabla.
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
