package Area;

import Zone.Zone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joseja on 10/19/16.
 */
@Entity
public class Area {

    private int id;

    private List<Zone> zones;

    private String name;

    public Area() {
        this.setName("alicante");
        this.setZones(new ArrayList<>(Arrays.asList(new Zone(), new Zone(), new Zone())));
    }

    public Area(String name, ArrayList<Zone> zones) {
        this.setName(name);
        this.setZones(zones);
    }

    @Id
    @Column(name="area_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @OneToMany
    @Column(name="zones")
    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Zone getZone(int zone) {
        return zones.get(zone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + ", Zones: " + zones;
    }
}
