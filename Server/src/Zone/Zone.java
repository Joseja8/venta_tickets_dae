package Zone;

import Event.EventManagerImp;

import javax.persistence.*;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class Zone {

    private int id;

    private EventManagerImp.Zones type;
    private int seats;
    private int remainingSeats;
    private float price;

    public Zone() {
    }

    public Zone(EventManagerImp.Zones zone, int seats) {
        this.setType(zone);
        this.setSeats(seats);
        this.setRemainingSeats(seats);
    }

    public EventManagerImp.Zones getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    @Id
    @Column(name="zone_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public void buySeat() {
        if(getRemainingSeats() == 0)
            throw new IllegalStateException("Not enough seats");
        setRemainingSeats(getRemainingSeats() - 1);
    }

    public void liberateSeat() {
        if(getRemainingSeats() == getSeats())
            throw new IllegalStateException("Too much seats");
        setRemainingSeats(getRemainingSeats() + 1);
    }

    public String toString() {
        return "Zone: " + getType() + ", Seats: " + getSeats();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!Zone.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        final Zone zone = (Zone) other;
        if (this.getType().equals(zone.getType())) {
            return true;
        }
        return false;
    }

    public float getPrice() {
        return price;
    }

    public void setType(EventManagerImp.Zones type) {
        this.type = type;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
