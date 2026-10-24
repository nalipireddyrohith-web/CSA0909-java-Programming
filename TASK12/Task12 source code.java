import java.util.*;

interface Pass {
    boolean isValid();
    double getDiscount();
}

class OneDayPass implements Pass {
    public boolean isValid() {
        return true;
    }

    public double getDiscount() {
        return 0;
    }
}

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double calculateFee(int hours, int hourOfDay);
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours, int hourOfDay) {
        return hours * 30;
    }
}

class ElectricBike extends Vehicle {
    ElectricBike(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours, int hourOfDay) {
        return 50;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours, int hourOfDay) {
        if (hourOfDay >= 9 && hourOfDay < 17) {
            return hours * 60;
        }
        return hours * 30;
    }
}

class ParkingFacility {
    private final String[][] slots;
    private final Map<String, Vehicle> parked = new HashMap<>();

    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    void park(Vehicle v) {
        if (parked.containsKey(v.getRegNo())) {
            System.out.println("Vehicle already parked");
            return;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = v.getRegNo();
                    parked.put(v.getRegNo(), v);
                    System.out.println(v.getRegNo() + " parked at Floor "
                            + (f + 1) + ", Slot " + (s + 1));
                    return;
                }
            }
        }

        System.out.println("Parking Full");
    }

    void exit(String regNo, int hours, int hourOfDay, Pass pass) {
        Vehicle v = parked.remove(regNo);

        if (v == null) {
            System.out.println("Vehicle not found");
            return;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (regNo.equals(slots[f][s])) {
                    slots[f][s] = null;
                    break;
                }
            }
        }

        double fee = v.calculateFee(hours, hourOfDay);

        if (pass != null && pass.isValid()) {
            fee = pass.getDiscount();
        }

        System.out.println("Vehicle: " + regNo);
        System.out.println("Parking Fee: Rs. " + fee);
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingFacility parking =
                new ParkingFacility(new int[]{20, 30, 40, 25, 50});

        parking.park(new Car("TN01AB1111"));
        parking.park(new ElectricBike("TN02CD2222"));
        parking.park(new DeliveryVan("TN03EF3333"));

        parking.exit("TN01AB1111", 3, 10, null);
        parking.exit("TN02CD2222", 2, 11, null);
        parking.exit("TN03EF3333", 2, 10, null);

        parking.park(new Car("TN04GH4444"));
        parking.exit("TN04GH4444", 5, 14, new OneDayPass());
    }
}
