interface Chargeable {
    double chargingFee(int kWh);

    default void displayChargingInfo() {
        System.out.println("Vehicle supports charging");
    }

    static void displayRate() {
        System.out.println("Charging Rate: Rs. 12 per kWh");
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

    abstract double ratePerHour();

    public double calculateFee(int minutes) {
        if (minutes <= 0) {
            return 0;
        }
        int hours = (minutes + 59) / 60;
        return hours * ratePerHour();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 10;
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 30;
    }
}

class ElectricCar extends Car implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new TwoWheeler("TN01A1"),
            new Car("TN02B2"),
            new ElectricCar("TN03C3")
        };

        for (Vehicle v : vehicles) {
            System.out.println("Registration: " + v.getRegNo());
            System.out.println("Parking Fee: Rs. " + v.calculateFee(130));

            if (v instanceof Chargeable) {
                Chargeable c = (Chargeable) v;
                c.displayChargingInfo();
                System.out.println("Charging Fee: Rs. " + c.chargingFee(10));
            }

            System.out.println();
        }

        Chargeable.displayRate();
    }
}
