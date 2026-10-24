interface Chargeable {
    double chargingFee(int kWh);
    default String capabilityName() { return "Charging capability"; }
    static boolean validEnergy(int kWh) { return kWh >= 0; }
}

abstract class Vehicle {
    private final String regNo;
    protected Vehicle(String regNo) { this.regNo = regNo; }
    public String getRegNo() { return regNo; }
    public abstract double calculateFee(int minutes);
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String regNo) { super(regNo); }
    @Override public double calculateFee(int minutes) {
        return Math.max(0, (minutes + 59) / 60) * 30.0;
    }
    @Override public double chargingFee(int kWh) {
        if (!Chargeable.validEnergy(kWh)) throw new IllegalArgumentException("Invalid kWh");
        return kWh * 12.0;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("TN03C3");
        System.out.println(car.getRegNo() + " fee=" + car.calculateFee(61));
        System.out.println(car.capabilityName() + ", charging=" + car.chargingFee(5));
    }
}
