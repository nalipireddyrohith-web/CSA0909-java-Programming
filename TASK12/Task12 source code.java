import java.time.LocalTime;
import java.util.*;

interface ParkingPass {
    boolean isValid();
    boolean coversParkingFee();
}
class OneDayPass implements ParkingPass {
    private final LocalTime validFrom;
    private final LocalTime validUntil;
    OneDayPass(LocalTime validFrom, LocalTime validUntil) {
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }
    @Override public boolean isValid() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(validFrom) && !now.isAfter(validUntil);
    }
    @Override public boolean coversParkingFee() { return isValid(); }
}
abstract class Vehicle {
    private final String regNo;
    protected Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo.toUpperCase();
    }
    String getRegNo() { return regNo; }
    abstract double calculateFee(int minutes, LocalTime entry, LocalTime exit);
}
class TwoWheeler extends Vehicle {
    TwoWheeler(String r) { super(r); }
    @Override double calculateFee(int m, LocalTime in, LocalTime out) {
        return m <= 0 ? 0 : ((m + 59) / 60) * 10.0;
    }
}
class Car extends Vehicle {
    Car(String r) { super(r); }
    @Override double calculateFee(int m, LocalTime in, LocalTime out) {
        return m <= 0 ? 0 : ((m + 59) / 60) * 30.0;
    }
}
class ElectricCar extends Car {
    ElectricCar(String r) { super(r); }
}
class EBike extends Vehicle {
    private static final double FLAT_FEE = 25.0;
    EBike(String r) { super(r); }
    @Override double calculateFee(int m, LocalTime in, LocalTime out) {
        return m <= 0 ? 0 : FLAT_FEE;
    }
}
class DeliveryVan extends Vehicle {
    DeliveryVan(String r) { super(r); }
    @Override double calculateFee(int m, LocalTime in, LocalTime out) {
        if (m <= 0) return 0;
        int hours = (m + 59) / 60;
        boolean daytime = !in.isBefore(LocalTime.of(9, 0)) && out.isBefore(LocalTime.of(17, 0).plusSeconds(1));
        double rate = daytime ? 60.0 : 30.0;
        return hours * rate;
    }
}
class ExtendedParkingSystem {
    private final String[][] slots;
    private final Map<String, Vehicle> active = new HashMap<>();
    ExtendedParkingSystem(int[] capacities) {
        slots = new String[capacities.length][];
        for (int i = 0; i < capacities.length; i++) slots[i] = new String[capacities[i]];
    }
    int[] allocate(String regNo) {
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = regNo;
                    return new int[]{f, s};
                }
            }
        }
        return null;
    }
    void park(Vehicle v) {
        if (active.containsKey(v.getRegNo())) throw new IllegalArgumentException("Duplicate registration");
        int[] position = allocate(v.getRegNo());
        if (position == null) throw new IllegalStateException("Parking full");
        active.put(v.getRegNo(), v);
        System.out.println(v.getClass().getSimpleName() + " parked at " + Arrays.toString(position));
    }
    double fee(Vehicle v, int minutes, LocalTime in, LocalTime out, ParkingPass pass) {
        if (pass != null && pass.coversParkingFee()) return 0.0;
        return v.calculateFee(minutes, in, out);
    }
}
public class ExtendedParkingDemo {
    public static void main(String[] args) {
        ExtendedParkingSystem p = new ExtendedParkingSystem(new int[]{2, 3, 4, 2, 5});
        LocalTime in = LocalTime.of(10, 0);
        LocalTime out = LocalTime.of(11, 30);
        Vehicle ebike = new EBike("TN10E100");
        Vehicle van = new DeliveryVan("TN20V200");
        Vehicle car = new Car("TN30C300");
        p.park(ebike);
        p.park(van);
        p.park(car);
        System.out.println("E-Bike fee: Rs " + p.fee(ebike, 90, in, out, null));
        System.out.println("Delivery van daytime fee: Rs " + p.fee(van, 90, in, out, null));
        System.out.println("Car fee with valid one-day pass: Rs " +
            p.fee(car, 90, in, out, new OneDayPass(LocalTime.MIN, LocalTime.MAX)));
    }
}
