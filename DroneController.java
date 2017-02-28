import java.util.ArrayList;
import java.util.List;
class DroneController {
    private List<Drone> drones = new ArrayList<Drone>();

    public void addDrone(Drone d){
        drones.add(d);
    }

    public void removeDrone(Drone d){
        drones.remove(d);
    }

    public List<Drone> getDrones(Drone d){
        return drones;
    }
}
