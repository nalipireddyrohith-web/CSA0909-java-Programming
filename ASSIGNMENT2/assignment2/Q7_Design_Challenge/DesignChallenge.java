import java.util.*;

public class DesignChallenge {
    static final int RUNS = 8;

    static double average(Runnable r) {
        for (int i = 0; i < 3; i++) r.run();
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            long s = System.nanoTime();
            r.run();
            total += System.nanoTime() - s;
        }
        return total / (double) RUNS / 1_000_000.0;
    }

    static String originalBuild(int fields) {
        String s = "";
        for (int i = 0; i < fields; i++) s += "FIELD-" + i + ";";
        return s;
    }

    static String redesignedBuild(int fields) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields; i++) sb.append("FIELD-").append(i).append(';');
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        System.out.println("Q7 - Original vs Redesigned String Construction");
        System.out.println("Fields | Original(ms) | Redesigned(ms) | Improvement");

        for (int n : sizes) {
            double original = average(() -> originalBuild(n));
            double redesigned = average(() -> redesignedBuild(n));
            double improvement = redesigned == 0 ? 0 : ((original - redesigned) / original) * 100.0;
            System.out.printf(Locale.US, "%d | %.3f | %.3f | %.2f%%%n",
                    n, original, redesigned, improvement);
        }

        System.out.println("\nDiagnosis:");
        System.out.println("The original solution repeatedly creates and copies immutable String values.");
        System.out.println("Redesign objective: reduce repeated intermediate String creation and character copying.");
        System.out.println("The redesign uses StringBuilder and performs append operations on a mutable buffer.");
        System.out.println("Trade-off: StringBuilder is mutable and should not be shared unsafely between threads.");
    }
}
