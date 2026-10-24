import java.util.Objects;

class Vehicle {
    private final String regNo;
    private final String type;
    private final long entryTimeMillis;

    Vehicle(String regNo, String type, long entryTimeMillis) {
        this.regNo = Objects.requireNonNull(regNo);
        this.type = Objects.requireNonNull(type);
        this.entryTimeMillis = entryTimeMillis;
    }

    String getRegNo() { return regNo; }
    String getType() { return type; }
    long getEntryTimeMillis() { return entryTimeMillis; }

    @Override
    public String toString() {
        return regNo + " (" + type + ")";
    }
}

public class Task1 {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("TN01AB1111", "CAR", System.currentTimeMillis()),
            new Vehicle("TN02CD2222", "BIKE", System.currentTimeMillis())
        };
        for (Vehicle v : vehicles) {
            if (v.getRegNo().equals("TN02CD2222")) {
                System.out.println("Found: " + v);
            }
        }

        String[] regNo = {"TN01AB1111", "TN02CD2222"};
        String[] type = {"CAR", "BIKE"};
        long[] entryTime = {1000L, 2000L};
        for (int i = 0; i < regNo.length; i++) {
            if (regNo[i].equals("TN02CD2222")) {
                System.out.println("Parallel arrays: " + regNo[i] + " " + type[i]
                    + " " + entryTime[i]);
            }
        }
    }
}
