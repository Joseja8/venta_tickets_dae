package Resources;

import Event.EventManager;
import Area.Area;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Joseja on 21-Jun-17.
 */
@Path("area/{area}")
public class AreaResource {

    @Autowired
    EventManager eventManager;

    @GET
    @Produces("application/json; charset=UTF-8")
    public Area test(@PathParam("area") String areaName) {
        System.out.print("1111111111");
        System.out.print(eventManager.getZoneTypes());
        System.out.print("2222222222");
        Area area = eventManager.getArea(areaName);
        System.out.print("3333333333");
        System.out.print(area.getName());
        return area;
    }
}
