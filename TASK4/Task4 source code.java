class Vehicle {
    String regNo;
    String type;
    String entryTime;

    Vehicle() {
        this("UNKNOWN", "UNKNOWN", "00:00");
    }

    Vehicle(String regNo, String type) {
        this(regNo, type, "00:00");
    }

    Vehicle(String regNo, String type, String entryTime) {
        this.regNo = regNo;
        this.type = type;
        this.entryTime = entryTime;
    }

    Vehicle(Vehicle v) {
        this(v.regNo, v.type, v.entryTime);
    }

    void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Entry Time: " + entryTime);
    }
}

class ParkingSlot {
    int slotNo;
    Vehicle vehicle;

    ParkingSlot() {
        this(1);
    }

    ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
        this.vehicle = null;
    }

    boolean isAvailable() {
        return vehicle == null;
    }
}

class ParkingTicket {
    static int nextTicketNo = 1001;
    int ticketNo;
    Vehicle vehicle;
    int slotNo;

    ParkingTicket(Vehicle vehicle, int slotNo) {
        this.ticketNo = nextTicketNo++;
        this.vehicle = new Vehicle(vehicle);
        this.slotNo = slotNo;
    }

    void displayTicket() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Registration Number: " + vehicle.regNo);
        System.out.println("Slot Number: " + slotNo);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("TN01AB1111", "CAR", "09:00");
        Vehicle v2 = new Vehicle("TN02CD2222", "BIKE", "09:15");

        ParkingSlot s1 = new ParkingSlot(1);
        ParkingSlot s2 = new ParkingSlot(2);

        s1.vehicle = v1;
        s2.vehicle = v2;

        ParkingTicket t1 = new ParkingTicket(v1, s1.slotNo);
        ParkingTicket t2 = new ParkingTicket(v2, s2.slotNo);

        t1.displayTicket();
        System.out.println();

        t2.displayTicket();
        System.out.println();

        v1.display();
        System.out.println("Slot Available: " + new ParkingSlot(3).isAvailable());
    }
}
