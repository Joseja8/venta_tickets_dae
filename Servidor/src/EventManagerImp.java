import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by joseja on 10/21/16.
 */
public class EventManagerImp implements EventManager {

    ArrayList<Event> events;
    ArrayList<Area> areas;

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
    public ArrayList<Event> getEvents(LocalDate date, Utils.EventTypes type) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventTypes().equals(type) && date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate()))
                results.add(event);
        return results;
    }

    @Override
    public ArrayList<Event> getEvents(LocalDate date, Utils.EventTypes type, String city) {
        ArrayList<Event> results = new ArrayList<>();
        for (Event event : events)
            if (event.getEventTypes().equals(type) && date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate()) && event.getArea().getCity().equals(city))
                results.add(event);
        return results;
    }

    @Override
    public Event getEvent(String name, LocalDate date, String city) {
        Event result = null;
        for (Event event : events)
            if (event.getName().equals(name) && date.isBefore(event.getFinishDate()) && date.isAfter(event.getStartDate()) && event.getArea().getCity().equals(city))
                result = event;
        return result;
    }

    @Override
    public ArrayList<Area> getAreas() {
        return areas;
    }
}
