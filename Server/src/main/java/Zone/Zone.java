package Zone;

import Event.EventManager;

import javax.persistence.*;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class Zone {

    private int id;

    private EventManager.ZoneType type;
    private int seats;
    private int remainingSeats;
    private float price;

    public Zone() {
    }

    public Zone(EventManager.ZoneType zoneType, int seats) {
        this.type = zoneType;
        this.seats = seats;
        this.setRemainingSeats(seats);
    }

    public EventManager.ZoneType getType() {
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
        remainingSeats--;
    }

    public void liberateSeat() {
        if(remainingSeats == seats)
            throw new IllegalStateException("Too much seats");
        remainingSeats++;
    }

    public float getPrice() {
        return price;
    }

    public void setType(EventManager.ZoneType type) {
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

    public String toString() {
        return "(" + type + ", " + seats + ")";
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
        if (this.type.equals(zone.getType())) {
            return true;
        }
        return false;
    }
}
