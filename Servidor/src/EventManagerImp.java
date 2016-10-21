import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joseja on 10/21/16.
 */
public class EventManagerImp implements EventManager {

    ArrayList<Event> events;

    @Override
    public ArrayList<Event> getEvents(String name) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getName().equals(name))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(String name, String city) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getName().equals(name) && event.getArea().getCity().equals(city))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(Date date, Utils.EventType type) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventType().equals(type) && date.after(event.getStartDate()) && date.before(event.getFinishDate()))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(Date date, Utils.EventType type, String city) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventType().equals(type) && date.after(event.getStartDate()) && date.before(event.getFinishDate()) && event.getArea().getCity().equals(city))
                results.add(event);
        return results;
    }

    @Override
    public Event getEvent(String name, Date date, String city) {
        Event result = null;
        for (Event event : events)
            if (event.getName().equals(name) && date.after(event.getStartDate()) && date.before(event.getFinishDate()) && event.getArea().getCity().equals(city))
                result = event;
        return result;
    }
}
