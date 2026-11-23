import java.time.LocalDateTime;

public class Task02Demo {
    public static void main(String[] args) {
        int minutes = 90;
        int wrongHours = minutes / 60;
        int correctHours = (minutes + 59) / 60;
        double fee = correctHours * 30.0;
        System.out.println("Wrong integer division hours: " + wrongHours);
        System.out.println("Correct billable hours: " + correctHours);
        System.out.println("Fee at Rs 30/hour: Rs " + fee);
        System.out.println("Entry type: " + LocalDateTime.class.getSimpleName());
    }
}
