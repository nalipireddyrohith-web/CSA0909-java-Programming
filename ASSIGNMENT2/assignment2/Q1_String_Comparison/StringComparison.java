import java.util.*;

public class StringComparison {
    static final int WARMUP = 5;
    static final int RUNS = 10;

    static String buildWithString(int fields, int tickets) {
        long checksum = 0;
        String last = "";
        for (int t = 0; t < tickets; t++) {
            String s = "";
            for (int f = 0; f < fields; f++) {
                s = s + "F" + f + "=VALUE;";
            }
            last = s;
            checksum += s.length();
        }
        if (checksum == -1) System.out.print("");
        return last;
    }

    static String buildWithStringBuilder(int fields, int tickets) {
        long checksum = 0;
        String last = "";
        for (int t = 0; t < tickets; t++) {
            StringBuilder sb = new StringBuilder();
            for (int f = 0; f < fields; f++) {
                sb.append("F").append(f).append("=VALUE;");
            }
            last = sb.toString();
            checksum += last.length();
        }
        if (checksum == -1) System.out.print("");
        return last;
    }

    static String buildWithStringBuffer(int fields, int tickets) {
        long checksum = 0;
        String last = "";
        for (int t = 0; t < tickets; t++) {
            StringBuffer sb = new StringBuffer();
            for (int f = 0; f < fields; f++) {
                sb.append("F").append(f).append("=VALUE;");
            }
            last = sb.toString();
            checksum += last.length();
        }
        if (checksum == -1) System.out.print("");
        return last;
    }

    static long time(Runnable r) {
        long start = System.nanoTime();
        r.run();
        return System.nanoTime() - start;
    }

    static double average(Runnable r) {
        for (int i = 0; i < WARMUP; i++) r.run();
        long total = 0;
        for (int i = 0; i < RUNS; i++) total += time(r);
        return total / (double) RUNS / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[][] workloads = {{5, 1000}, {50, 10000}, {200, 5000}};
        System.out.println("Q1 - String vs StringBuilder vs StringBuffer");
        System.out.println("Workload, String(ms), StringBuilder(ms), StringBuffer(ms)");

        for (int[] w : workloads) {
            int fields = w[0], tickets = w[1];
            double a = average(() -> buildWithString(fields, tickets));
            double b = average(() -> buildWithStringBuilder(fields, tickets));
            double c = average(() -> buildWithStringBuffer(fields, tickets));
            System.out.printf(Locale.US, "%d fields x %d tickets, %.3f, %.3f, %.3f%n",
                    fields, tickets, a, b, c);
        }

        System.out.println("\nComplexity:");
        System.out.println("Repeated String + inside a loop can repeatedly copy accumulated characters.");
        System.out.println("StringBuilder and StringBuffer provide append-based construction.");
        System.out.println("StringBuffer is synchronized; StringBuilder is normally preferred for thread-confined text.");
    }
}
