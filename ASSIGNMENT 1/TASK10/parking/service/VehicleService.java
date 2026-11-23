package parking.service;
import parking.model.Vehicle;
public class VehicleService {
    public static void show(Vehicle v) {
        System.out.println(v.getRegNo() + " slot=" + v.getSlot());
    }
}
