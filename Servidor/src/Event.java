import org.joda.time.LocalDate;

/**
 * Created by joseja on 10/19/16.
 */
public class Event {

    private String name;
    private Utils.EventTypes eventTypes;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Area area;

    public Event(String name, Utils.EventTypes eventTypes, LocalDate start, LocalDate finish, Area area) {
        this.name = name;
        this.eventTypes = eventTypes;
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

    public Utils.EventTypes getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(Utils.EventTypes eventTypes) {
        this.eventTypes = eventTypes;
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
}
