package Event;

import Area.Area;

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
    private String startDate;
    private String finishDate;


    public Event() {
    }

    public Event(String name, EventManager.EventTypes eventType, String start, String finish, Area area) {
        this.name = name;
        this.eventType = eventType;
        this.startDate = start;
        this.finishDate = finish;
        this.area = area;
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

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    @ManyToOne
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setEventType(EventManager.EventTypes eventType) {
        this.eventType = eventType;
    }
}
