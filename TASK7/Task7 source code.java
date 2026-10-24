import java.util.Objects;

class Vehicle {
    private final String regNo;
    private final String type;

    Vehicle(String regNo, String type) {
        this.regNo = regNo;
        this.type = type;
    }

    final String getRegNo() {
        return regNo;
    }

    double calculateFee(int hours) {
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle{regNo='" + regNo + "', type='" + type + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) obj;
        return regNo.equalsIgnoreCase(v.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo.toUpperCase());
    }
}

class Car extends Vehicle {
    private final double rate = 30;

    Car(String regNo) {
        super(regNo, "Car");
    }

    @Override
    double calculateFee(int hours) {
        return hours * rate;
    }
}

class Bike extends Vehicle {
    private final double rate = 10;

    Bike(String regNo) {
        super(regNo, "Bike");
    }

    @Override
    double calculateFee(int hours) {
        return hours * rate;
    }
}

class ElectricCar extends Vehicle {
    private final double rate = 30;

    ElectricCar(String regNo) {
        super(regNo, "Electric Car");
    }

    @Override
    double calculateFee(int hours) {
        return hours * rate + 50;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("TN01AB1111"),
            new Bike("TN02CD2222"),
            new ElectricCar("TN03EF3333")
        };

        for (Vehicle v : vehicles) {
            System.out.println(v);
            System.out.println("Registration Number: " + v.getRegNo());
            System.out.println("Parking Fee: Rs. " + v.calculateFee(3));
            System.out.println();
        }

        Vehicle v1 = new Car("TN01AB1111");
        Vehicle v2 = new Car("TN01AB1111");

        System.out.println("Vehicles Equal: " + v1.equals(v2));
        System.out.println("Hash Code: " + v1.hashCode());
    }
}
