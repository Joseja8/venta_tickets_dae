package Event;

import Area.Area;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class Event {

    private int id;

    private Area area;

    private String name;
    private EventManager.EventTypes eventType;
    private LocalDate startDate;
    private LocalDate finishDate;


    public Event() {
        this.setName("leyendas");
        this.setEventType(EventManager.EventTypes.Festival);
        this.setStartDate(LocalDate.parse("22222222"));
        this.setFinishDate(LocalDate.parse("22222222"));
        this.setArea(new Area());
    }

    public Event(String name, EventManager.EventTypes eventType, LocalDate start, LocalDate finish, Area area) {
        this.setName(name);
        this.setEventType(eventType);
        this.setStartDate(start);
        this.setFinishDate(finish);
        this.setArea(area);
    }

    @Id
    @Column(name="event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public EventManager.EventTypes getEventType() {
        return eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    @OneToOne
    public Area getArea() {
        return area;
    }

    public String toString() {
        return "Name: " + getName() + ", Event type: " + eventType;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!Event.class.isAssignableFrom(other.getClass())) {
            return false;
        }
        final Event event = (Event) other;
        if (this.getName().equals(event.getName())) {
            return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setEventType(EventManager.EventTypes eventType) {
        this.eventType = eventType;
    }
}
