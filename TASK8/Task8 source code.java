interface Chargeable {
    double chargingFee(int kWh);
}

abstract class Vehicle {
    private final String regNo;

    protected Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo;
    }

    public String getRegNo() { return regNo; }
    protected abstract double ratePerHour();

    public double calculateFee(int minutes) {
        if (minutes <= 0) return 0;
        int hours = (minutes + 59) / 60;
        return hours * ratePerHour();
    }

    public double calculateFee(java.time.LocalTime in, java.time.LocalTime out) {
        long minutes = java.time.Duration.between(in, out).toMinutes();
        if (minutes < 0) minutes += 24 * 60;
        return calculateFee((int) minutes);
    }

    @Override public boolean equals(Object o) {
        return o instanceof Vehicle && regNo.equalsIgnoreCase(((Vehicle) o).regNo);
    }
    @Override public int hashCode() { return regNo.toUpperCase().hashCode(); }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) { super(regNo); }
    @Override protected double ratePerHour() { return 10; }
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }
    @Override protected double ratePerHour() { return 30; }
}

class ElectricCar extends Car implements Chargeable {
    ElectricCar(String regNo) { super(regNo); }
    @Override public double chargingFee(int kWh) {
        if (kWh < 0) throw new IllegalArgumentException("kWh cannot be negative");
        return 12.0 * kWh;
    }
}

public class FeeDemo {
    public static void main(String[] args) {
        Vehicle[] parked = { new TwoWheeler("TN01A1"), new Car("TN02B2"),
            new ElectricCar("TN03C3") };
        for (Vehicle v : parked) {
            double fee = v.calculateFee(130);
            if (v instanceof Chargeable c) fee += c.chargingFee(10);
            System.out.println(v.getClass().getSimpleName() + " " + v.getRegNo()
                + " -> Rs " + fee);
        }
        System.out.println(new Car("TN02B2").equals(new ElectricCar("TN02B2")));
    }
}
