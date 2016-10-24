import java.util.ArrayList;

/**
 * Created by joseja on 10/19/16.
 */
public class Area {

    private String city;
    private ArrayList<Zone> zones;

    public Area() {}

    public Area(String city, ArrayList<Zone> zones) {
        this.city = city;
        this.zones = zones;
    }

    public Area(String city) {
        this.city = city;
        this.zones = new ArrayList<>();
    }

    public void addZone(Zone zone) {
        getZones().add(zone);
    }

    public ArrayList<Zone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
