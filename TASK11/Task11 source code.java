import java.util.*;

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        if (regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid registration number");
        }
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    abstract double ratePerHour();
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

class Bike extends Vehicle {
    Bike(String regNo) {
        super(regNo);
    }

    @Override
    double ratePerHour() {
        return 10;
    }
}

class ParkingTicket {
    private static int nextId = 1001;
    private final int ticketId;
    private final Vehicle vehicle;
    private final int floor;
    private final int slot;
    private final int minutes;

    ParkingTicket(Vehicle vehicle, int floor, int slot, int minutes) {
        this.ticketId = nextId++;
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
        this.minutes = minutes;
    }

    public String getRegNo() {
        return vehicle.getRegNo();
    }

    public double calculateFee() {
        if (minutes <= 0) {
            return 0;
        }
        int hours = (minutes + 59) / 60;
        return hours * vehicle.ratePerHour();
    }

    public void display() {
        System.out.println("Ticket: " + ticketId
                + ", Vehicle: " + getRegNo()
                + ", Floor: " + floor
                + ", Slot: " + slot
                + ", Fee: Rs. " + calculateFee());
    }
}

class ParkingFacility {
    private final String[][] slots;
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int i = 0; i < slotsPerFloor.length; i++) {
            if (slotsPerFloor[i] <= 0) {
                throw new IllegalArgumentException("Invalid slot capacity");
            }
            slots[i] = new String[slotsPerFloor[i]];
        }
    }

    public ParkingTicket park(Vehicle vehicle, int minutes) {
        if (minutes < 0) {
            System.out.println("Invalid duration");
            return null;
        }

        String regNo = vehicle.getRegNo();

        if (activeTickets.containsKey(regNo)) {
            System.out.println("Duplicate vehicle");
            return null;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = regNo;
                    ParkingTicket ticket =
                            new ParkingTicket(vehicle, f, s, minutes);
                    activeTickets.put(regNo, ticket);
                    System.out.println("Vehicle parked successfully");
                    return ticket;
                }
            }
        }

        System.out.println("Parking full");
        return null;
    }

    public double exit(String regNo) {
        ParkingTicket ticket = activeTickets.remove(regNo);

        if (ticket == null) {
            System.out.println("Ticket not found");
            return -1;
        }

        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (regNo.equals(slots[f][s])) {
                    slots[f][s] = null;
                    break;
                }
            }
        }

        ticket.display();
        return ticket.calculateFee();
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingFacility parking = new ParkingFacility(new int[]{2, 1});

        Vehicle car = new Car("TN01AB1111");
        Vehicle bike = new Bike("TN02CD2222");

        ParkingTicket t1 = parking.park(car, 120);
        ParkingTicket t2 = parking.park(bike, 60);

        parking.park(new Car("TN01AB1111"), 30);

        double fee1 = parking.exit("TN01AB1111");
        double fee2 = parking.exit("TN02CD2222");

        System.out.println("Total Collection: Rs. " + (fee1 + fee2));

        parking.park(new Car("TN03EF3333"), 0);
        parking.exit("TN03EF3333");
        parking.exit("TN99ZZ9999");
    }
}
