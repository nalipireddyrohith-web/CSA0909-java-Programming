package parking.app;
import parking.model.Vehicle;
import parking.service.VehicleService;
public class Task10Demo {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN10Z9");
        v.setSlot(4);
        VehicleService.show(v);
        Integer a = 1000, b = 1000;
        System.out.println("Integer equals: " + a.equals(b));
        System.out.println("Use equals() rather than == for wrapper value comparison.");
    }
}
