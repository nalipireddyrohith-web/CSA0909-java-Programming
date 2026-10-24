import java.util.*;

abstract class Vehicle {
    private final String regNo;
    protected Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo.toUpperCase();
    }
    String getRegNo() { return regNo; }
    abstract double ratePerHour();
    double fee(int minutes) {
        if (minutes <= 0) return 0;
        return ((minutes + 59) / 60) * ratePerHour();
    }
    @Override public boolean equals(Object o) {
        return o instanceof Vehicle v && regNo.equals(v.regNo);
    }
    @Override public int hashCode() { return regNo.hashCode(); }
}
class Bike extends Vehicle {
    Bike(String r) { super(r); }
    @Override double ratePerHour() { return 10; }
}
class Car extends Vehicle {
    Car(String r) { super(r); }
    @Override double ratePerHour() { return 30; }
}
class EV extends Car {
    EV(String r) { super(r); }
    double chargingFee(int kWh) { return kWh * 12.0; }
}
class ParkingTicket {
    private static int nextId = 1000;
    final int id = nextId++;
    final Vehicle vehicle;
    final int floor;
    final int slot;
    final long entryMillis;
    ParkingTicket(Vehicle v, int f, int s, long t) {
        vehicle = v; floor = f; slot = s; entryMillis = t;
    }
}
class ParkingSystem {
    private final String[][] slots;
    private final Map<String, ParkingTicket> active = new HashMap<>();

    ParkingSystem(int[] capacities) {
        slots = new String[capacities.length][];
        for (int i = 0; i < capacities.length; i++) slots[i] = new String[capacities[i]];
    }

    ParkingTicket enter(Vehicle v) {
        if (active.containsKey(v.getRegNo())) throw new IllegalArgumentException("Duplicate registration");
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = v.getRegNo();
                    ParkingTicket t = new ParkingTicket(v, f, s, System.currentTimeMillis());
                    active.put(v.getRegNo(), t);
                    return t;
                }
            }
        }
        return null;
    }

    double exit(String regNo, int simulatedMinutes) {
        ParkingTicket t = active.remove(regNo.toUpperCase());
        if (t == null) throw new IllegalArgumentException("No active ticket");
        slots[t.floor][t.slot] = null;
        return t.vehicle.fee(simulatedMinutes);
    }
}

public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingSystem p = new ParkingSystem(new int[]{1, 2});
        ParkingTicket t1 = p.enter(new Bike("TN01A1"));
        ParkingTicket t2 = p.enter(new Car("TN02B2"));
        System.out.println("Ticket issued: " + t1.id + ", slot=" + t1.floor + ":" + t1.slot);
        System.out.println("Ticket issued: " + t2.id + ", slot=" + t2.floor + ":" + t2.slot);
        try {
            p.enter(new Car("TN02B2"));
            System.out.println("Duplicate test: FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate test: PASS");
        }
        System.out.println("Bike fee for 60 min: Rs " + p.exit("TN01A1", 60));
        System.out.println("Car fee for 61 min: Rs " + p.exit("TN02B2", 61));
        System.out.println("Boundary 0-minute car fee: Rs " + new Car("TN99Z9").fee(0));
        System.out.println("Boundary 60-minute car fee: Rs " + new Car("TN99Z9").fee(60));
        System.out.println("Last free slot test: " + (p.enter(new Car("TN03C3")) != null ? "PASS" : "FAIL"));
    }
}
