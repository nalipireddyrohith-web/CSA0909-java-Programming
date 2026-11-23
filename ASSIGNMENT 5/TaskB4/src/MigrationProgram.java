import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class MigrationProgram {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java MigrationProgram <passes.csv>");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";
        Path file = Path.of(args[0]);

        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD")) {
            con.setAutoCommit(false);

            String sql = "INSERT INTO bus_pass(pass_id, reg_no, name, route_no, amount) VALUES (?, ?, ?, ?, ?)";
            int loaded = 0;
            int failed = 0;

            try (BufferedReader r = Files.newBufferedReader(file);
                 PreparedStatement ps = con.prepareStatement(sql)) {

                String line;
                while ((line = r.readLine()) != null) {
                    String[] p = line.split(",", -1);

                    if (p.length != 5) {
                        failed++;
                        System.out.println("FAILED: " + line);
                        continue;
                    }

                    try {
                        ps.setString(1, p[0]);
                        ps.setString(2, p[1]);
                        ps.setString(3, p[2]);
                        ps.setInt(4, Integer.parseInt(p[3]));
                        ps.setDouble(5, Double.parseDouble(p[4]));
                        ps.addBatch();
                        loaded++;

                        if (loaded % 1000 == 0) ps.executeBatch();
                    } catch (NumberFormatException e) {
                        failed++;
                        System.out.println("FAILED: " + line);
                    }
                }

                ps.executeBatch();
                con.commit();
                System.out.println("Loaded = " + loaded);
                System.out.println("Failed = " + failed);

            } catch (Exception e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }
}
