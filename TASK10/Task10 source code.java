class Vehicle {
    private String regNo;
    private String type;
    private int duration;
    private Integer slotNo;

    public Vehicle(String regNo, String type, int duration, Integer slotNo) {
        setRegNo(regNo);
        setType(type);
        setDuration(duration);
        setSlotNo(slotNo);
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        if (regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid registration number");
        }
        this.regNo = regNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.duration = duration;
    }

    public Integer getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        if (slotNo == null || slotNo <= 0) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        this.slotNo = slotNo;
    }

    public double calculateFee(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Invalid hourly rate");
        }
        int hours = (duration + 59) / 60;
        return hours * hourlyRate;
    }

    public void display() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Slot Number: " + slotNo);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1111", "CAR", 90, 1);

        v.display();
        System.out.println("Parking Fee: Rs. " + v.calculateFee(30));

        Integer a = 1000;
        Integer b = 1000;

        System.out.println("Compare using equals(): " + a.equals(b));
    }
}
