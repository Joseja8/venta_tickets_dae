package Domain;

import Interfaces.EventManager;
import Interfaces.Implementations.EventManagerImp;

/**
 * Created by joseja on 10/19/16.
 */
public class Zone {

    private PriceTable priceTable;

    private EventManagerImp.Zones id;
    private int seats;
    private int remainingSeats;
    private float price;

    public Zone() {
        this.id = EventManager.Zones.A;
        this.seats = 100;
        this.remainingSeats = 100;
        this.price = 0;
    }

    public Zone(EventManagerImp.Zones zone, int seats) {
        this.id = zone;
        this.seats = seats;
        this.remainingSeats = seats;
    }

    public EventManagerImp.Zones getId() {
        return id;
    }

    public void setId(EventManagerImp.Zones id) {
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

    public String toString() {
        return "Zone: " + id + ", Seats: " + seats;
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
        if (this.id.equals(zone.getId())) {
            return true;
        }
        return false;
    }

    public PriceTable getPriceTable() {
        return priceTable;
    }

    public void setPriceTable(PriceTable priceTable) {
        this.priceTable = priceTable;
    }
}
