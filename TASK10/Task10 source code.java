class Vehicle {
    private final String regNo;
    private String type;

    public Vehicle(String regNo, String type) {
        if (regNo == null || regNo.isBlank()) {
            throw new IllegalArgumentException("Registration required");
        }

        this.regNo = regNo;
        setType(type);
    }

    public String getRegNo() {
        return regNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type required");
        }

        this.type = type;
    }
}

public class Task10 {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1111", "CAR");

        System.out.println(v.getRegNo() + " " + v.getType());

        v.setType("ELECTRIC_CAR");

        System.out.println(v.getType());
    }
}
