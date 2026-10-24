class Vehicle {
    String regNo;
    String type;

    Vehicle(String regNo, String type) {
        this.regNo = regNo;
        this.type = type;
        System.out.println("Vehicle Constructor");
    }

    void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Vehicle Type: " + type);
    }
}

class Car extends Vehicle {
    double rate;

    Car(String regNo, double rate) {
        super(regNo, "Car");
        this.rate = rate;
        System.out.println("Car Constructor");
    }

    void calculateFee(int hours) {
        System.out.println("Car Parking Fee: Rs. " + (hours * rate));
    }
}

class Bike extends Vehicle {
    double rate;

    Bike(String regNo, double rate) {
        super(regNo, "Bike");
        this.rate = rate;
        System.out.println("Bike Constructor");
    }

    void calculateFee(int hours) {
        System.out.println("Bike Parking Fee: Rs. " + (hours * rate));
    }
}

class ElectricCar extends Car {
    boolean chargingRequired;

    ElectricCar(String regNo, double rate, boolean chargingRequired) {
        super(regNo, rate);
        this.chargingRequired = chargingRequired;
        System.out.println("ElectricCar Constructor");
    }

    void displayChargingStatus() {
        System.out.println("Charging Required: " + chargingRequired);
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricCar e = new ElectricCar("TN01AB1111", 50, true);

        e.display();
        e.calculateFee(3);
        e.displayChargingStatus();

        Bike b = new Bike("TN02CD2222", 20);
        b.display();
        b.calculateFee(2);
    }
}
