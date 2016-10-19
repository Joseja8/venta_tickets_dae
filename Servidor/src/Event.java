import java.util.Date;

/**
 * Created by joseja on 10/19/16.
 */
public class Event {

    private String name;
    private Utils.EventType eventType;
    private Date startDate;
    private Date finishDate;
    private Area area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Utils.EventType getEventType() {
        return eventType;
    }

    public void setEventType(Utils.EventType eventType) {
        this.eventType = eventType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
