import java.util.List;

/**
 * Created by joseja on 10/19/16.
 */
public class Area {

    private String address;
    private List<Zone> zones;

    public void addZone(Utils.Zones zone) {
        getZones().add(new Zone(zone));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}
