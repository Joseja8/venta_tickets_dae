package Area;

import Zone.Zone;

import javax.persistence.*;
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
    }

    public Area(String name, List<Zone> zones) {
        this.name = name;
        this.zones = zones;
    }

    @Id
    @Column(name="area_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany
    @Column(name="zones")
    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Zone getZone(int zoneIndex) {
        return zones.get(zoneIndex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}
