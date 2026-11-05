import java.util.*;

class Student {
    private final String regNo;
    private final String name;

    Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return regNo.equals(s.regNo);
    }

    @Override
    public String toString() {
        return regNo + " " + name;
    }
}

class BrokenStudent {
    String regNo;
    String name;

    BrokenStudent(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BrokenStudent)) return false;
        return regNo.equals(((BrokenStudent) o).regNo);
    }
}

public class HashSetExperiment {
    public static void main(String[] args) {
        System.out.println("Q3 - HashSet and hashCode-equals contract");

        Set<BrokenStudent> broken = new HashSet<>();
        broken.add(new BrokenStudent("192311001", "Arun"));
        broken.add(new BrokenStudent("192311001", "Arun"));
        System.out.println("Without hashCode override: " + broken.size());

        Set<Student> fixed = new HashSet<>();
        fixed.add(new Student("192311001", "Arun"));
        fixed.add(new Student("192311002", "Divya"));
        fixed.add(new Student("192311001", "Arun"));
        System.out.println("With correct hashCode needed: " + fixed.size());

        System.out.println("Complete-the-Code expected output: Unique students: 2");

        System.out.println("\nReason:");
        System.out.println("HashSet first uses hashCode to select a bucket and then equals to distinguish matching elements.");
        System.out.println("If equals says two objects are equal, their hash codes must be equal.");
        System.out.println("The Student class in the completed program should override hashCode using regNo.");
    }
}
