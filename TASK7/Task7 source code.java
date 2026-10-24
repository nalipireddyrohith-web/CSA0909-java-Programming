import java.util.Objects;

class Vehicle {
    private final String regNo;
    Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo;
    }
    String getRegNo() { return regNo; }

    @Override public String toString() { return getClass().getSimpleName() + "[" + regNo + "]"; }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle other)) return false;
        return regNo.equalsIgnoreCase(other.regNo);
    }
    @Override public int hashCode() { return Objects.hash(regNo.toUpperCase()); }
}

public class EqualityDemo {
    public static void main(String[] args) {
        Vehicle a = new Vehicle("TN01AB1111");
        Vehicle b = new Vehicle("tn01ab1111");
        System.out.println(a);
        System.out.println("Equal registration: " + a.equals(b));
        System.out.println("Equal hash: " + (a.hashCode() == b.hashCode()));
    }
}
