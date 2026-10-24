
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] capacity = {20, 50, 35};
        String[][] parking = new String[3][];

        for (int i = 0; i < 3; i++) {
            parking[i] = new String[capacity[i]];
        }

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        System.out.print("Enter floor number: ");
        int floor = sc.nextInt();

        System.out.println("Number of slots: " + capacity[floor - 1]);

        System.out.print("Enter parking duration in minutes: ");
        int minutes = sc.nextInt();

        System.out.print("Enter hourly parking rate: ");
        double rate = sc.nextDouble();

        int hours = (minutes + 59) / 60;
        double fee = hours * rate;

        System.out.println("Parking Duration: " + minutes + " minutes");
        System.out.println("Billable Hours: " + hours);
        System.out.println("Parking Fee: Rs. " + fee);

        sc.close();
    }
}
