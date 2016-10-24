/**
 * Created by joseja on 10/19/16.
 */
public class Zone {

    private Utils.Zones id;
    private int seats;
    private int remainingSeats;
    private float price;

    public Zone(Utils.Zones zone, int seats) {
        this.id = zone;
        this.seats = seats;
        this.remainingSeats = seats;
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

    public int getFreeSeats() {
        return remainingSeats;
    }

    public void buySeat() {
        if(remainingSeats == 0)
            throw new IllegalStateException("Not enough seats");
        remainingSeats--;
    }

    public void freeSeat() {
        if(remainingSeats == seats)
            throw new IllegalStateException("Too much seats");
        remainingSeats++;
    }
}
