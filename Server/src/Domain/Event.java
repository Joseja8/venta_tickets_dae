package Domain;

import Interfaces.EventManager;
import org.joda.time.LocalDate;

/**
 * Created by joseja on 10/19/16.
 */
public class Event {

    private String name;
    private EventManager.EventTypes eventType;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Area area;

    public Event() {
        this.name = "leyendas";
        this.eventType = EventManager.EventTypes.Festival;
        this.startDate = LocalDate.parse("22222222");
        this.finishDate = LocalDate.parse("22222222");
        this.area = new Area();
    }

    public Event(String name, EventManager.EventTypes eventType, LocalDate start, LocalDate finish, Area area) {
        this.name = name;
        this.eventType = eventType;
        this.startDate = start;
        this.finishDate = finish;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventManager.EventTypes getEventType() {
        return eventType;
    }

    public void setEventType(EventManager.EventTypes eventType) {
        this.eventType = eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String toString() {
        return "Name: " + name + ", Event type: " + eventType;
    }

    @Override
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
