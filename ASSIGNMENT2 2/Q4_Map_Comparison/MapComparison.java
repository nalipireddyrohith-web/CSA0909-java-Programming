import java.util.*;

public class MapComparison {
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

    static Map<String, Integer> makeHash(int n) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) m.put(String.format("M%06d", i), i);
        return m;
    }

    static Map<String, Integer> makeTree(int n) {
        Map<String, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) m.put(String.format("M%06d", i), i);
        return m;
    }

    static Map<String, Integer> makeLinked(int n) {
        Map<String, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) m.put(String.format("M%06d", i), i);
        return m;
    }

    static double lookup(Map<String, Integer> map, int n) {
        long sum = 0;
        for (int i = 0; i < 100000; i++) sum += map.get("M" + String.format("%06d", i % n));
        return sum;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        System.out.println("Q4 - Map comparison");
        System.out.println("Size | HashMap lookup | TreeMap lookup | LinkedHashMap lookup | TreeMap code-order report");

        for (int n : sizes) {
            Map<String,Integer> h = makeHash(n);
            Map<String,Integer> t = makeTree(n);
            Map<String,Integer> l = makeLinked(n);

            double a = average(() -> lookup(h, n));
            double b = average(() -> lookup(t, n));
            double c = average(() -> lookup(l, n));
            double d = average(() -> {
                long sum = 0;
                for (Map.Entry<String,Integer> e : t.entrySet()) sum += e.getValue();
                if (sum == -1) System.out.print("");
            });

            System.out.printf(Locale.US, "%d | %.3f ms | %.3f ms | %.3f ms | %.3f ms%n", n, a, b, c, d);
        }

        System.out.println("\nMap choice:");
        System.out.println("HashMap naturally provides fast average lookup but no sorted order.");
        System.out.println("TreeMap maintains key order and supports O(log n) basic operations.");
        System.out.println("LinkedHashMap preserves insertion order with HashMap-like average lookup.");
        System.out.println("Hashtable is generally not preferred for new code; modern collections and explicit synchronization choices are usually clearer.");
    }
}
