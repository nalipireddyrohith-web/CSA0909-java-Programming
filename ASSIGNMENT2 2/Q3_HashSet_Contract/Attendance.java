import java.util.HashSet;
import java.util.Set;

class AttendanceStudent {
    private final String regNo;
    private final String name;

    AttendanceStudent(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceStudent)) return false;
        AttendanceStudent s = (AttendanceStudent) o;
        return regNo.equals(s.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }

    @Override
    public String toString() {
        return regNo + " " + name;
    }
}

public class Attendance {
    public static void main(String[] args) {
        Set<AttendanceStudent> present = new HashSet<>();
        present.add(new AttendanceStudent("192311001", "Arun"));
        present.add(new AttendanceStudent("192311002", "Divya"));
        present.add(new AttendanceStudent("192311001", "Arun"));
        System.out.println("Unique students: " + present.size());
    }
}
