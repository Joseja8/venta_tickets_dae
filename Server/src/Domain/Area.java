package Domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joseja on 10/19/16.
 */
public class Area {

    private String city;
    private ArrayList<Zone> zones;

    public Area() {
        this.city = "alicante";
        this.zones = new ArrayList<>(Arrays.asList(new Zone(), new Zone(), new Zone()));
    }

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

    public Zone getZone(int zone) {
        return zones.get(zone);
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

    public String toString() {
        return "City: " + city + ", Zones: " + zones;
    }
}
