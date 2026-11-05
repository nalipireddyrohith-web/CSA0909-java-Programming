import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReportGenerator {
    static String manual(List<String> files) {
        StringBuilder out = new StringBuilder();
        for (String name : files) {
            BufferedReader br = null;
            try {
                br = Files.newBufferedReader(Path.of(name));
                out.append(br.readLine()).append('\n');
            } catch (IOException e) {
                out.append("ERROR: ").append(name).append(" -> ").append(e.getMessage()).append('\n');
            } finally {
                if (br != null) try { br.close(); } catch (IOException ignored) { }
            }
        }
        return out.toString();
    }

    static String safe(List<String> files) {
        StringBuilder out = new StringBuilder();
        for (String name : files) {
            try (BufferedReader br = Files.newBufferedReader(Path.of(name))) {
                out.append(br.readLine()).append('\n');
            } catch (IOException e) {
                out.append("ERROR: ").append(name).append(" -> ").append(e.getMessage()).append('\n');
            }
        }
        return out.toString();
    }

    public static void main(String[] args) throws Exception {
        Path dir = Path.of("input");
        Files.createDirectories(dir);
        Files.writeString(dir.resolve("store1.txt"), "Store1 Sales: 12500");
        Files.writeString(dir.resolve("store2.txt"), "Store2 Sales: 9800");
        List<String> files = List.of("input/store1.txt", "input/store2.txt", "input/missing.txt");
        System.out.println("MANUAL CLOSE VERSION");
        System.out.print(manual(files));
        System.out.println("TRY-WITH-RESOURCES VERSION");
        System.out.print(safe(files));
        System.out.println("Both versions preserve the same success/error report semantics.");
    }
}
