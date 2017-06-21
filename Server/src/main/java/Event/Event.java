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
    private EventManager.EventType eventType;
    private String startDate;
    private String finishDate;


    public Event() {
    }

    public Event(String name, EventManager.EventType eventType, String start, String finish, Area area) {
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

    public EventManager.EventType getEventType() {
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

    public void setEventType(EventManager.EventType eventType) {
        this.eventType = eventType;
    }

    public String toString() {
        return "(" + name + ",  " + eventType + ")";
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
        if (this.name.equals(event.getName())) {
            return true;
        }
        return false;
    }

}
