
import java.util.Scanner;

class Vehicle {
    String regNo, type, entryTime;

    Vehicle(String regNo, String type, String entryTime) {
        this.regNo = regNo;
        this.type = type;
        this.entryTime = entryTime;
    }
}

class ParkingSlot {
    int slotNo;
    Vehicle vehicle;

    ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
    }
}

class Ticket {
    static int nextTicketNo = 1001;
    int ticketNo;

    Ticket() {
        ticketNo = nextTicketNo++;
    }
}

class ParkingLot {
    ParkingSlot[] slots;

    ParkingLot(int capacity) {
        slots = new ParkingSlot[capacity];
        for (int i = 0; i < capacity; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    void parkVehicle(Scanner sc) {
        System.out.print("Enter Registration Number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Entry Time: ");
        String entryTime = sc.nextLine();

        for (ParkingSlot s : slots) {
            if (s.vehicle != null &&
                s.vehicle.regNo.equalsIgnoreCase(regNo)) {
                System.out.println("Vehicle Already Parked");
                return;
            }
        }

        for (ParkingSlot s : slots) {
            if (s.vehicle == null) {
                s.vehicle = new Vehicle(regNo, type, entryTime);
                Ticket t = new Ticket();
                System.out.println("Vehicle Parked Successfully");
                System.out.println("Slot Number: " + s.slotNo);
                System.out.println("Ticket Number: " + t.ticketNo);
                return;
            }
        }

        System.out.println("Parking Full");
    }

    void searchVehicle(Scanner sc) {
        System.out.print("Enter Registration Number: ");
        String regNo = sc.nextLine();

        for (ParkingSlot s : slots) {
            if (s.vehicle != null &&
                s.vehicle.regNo.equalsIgnoreCase(regNo)) {
                System.out.println("Vehicle Found");
                System.out.println("Registration Number: " + s.vehicle.regNo);
                System.out.println("Type: " + s.vehicle.type);
                System.out.println("Entry Time: " + s.vehicle.entryTime);
                System.out.println("Slot Number: " + s.slotNo);
                return;
            }
        }

        System.out.println("Vehicle Not Found");
    }

    void displayVehicles() {
        for (ParkingSlot s : slots) {
            if (s.vehicle != null) {
                System.out.println(s.slotNo + " " +
                    s.vehicle.regNo + " " +
                    s.vehicle.type + " " +
                    s.vehicle.entryTime);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Parking Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity <= 0) {
            System.out.println("Invalid Capacity");
            sc.close();
            return;
        }

        ParkingLot lot = new ParkingLot(capacity);

        while (true) {
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Search Vehicle");
            System.out.println("3. Display Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    lot.parkVehicle(sc);
                    break;
                case 2:
                    lot.searchVehicle(sc);
                    break;
                case 3:
                    lot.displayVehicles();
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
