/**
 * Created by joseja on 10/19/16.
 */
public class Ticket {

    private int id;
    private float price;
    private Event event;
    private Utils.Zones zone;

    public Ticket(Event event, Utils.Zones zone) {
        this.event = event;
        this.zone = zone;
        this.price = PriceTable.getPrice(event, zone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
