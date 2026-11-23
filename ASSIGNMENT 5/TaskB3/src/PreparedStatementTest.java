import java.sql.*;

public class PreparedStatementTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";
        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD");
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO bus_pass(pass_id, reg_no, name, route_no, amount) VALUES (?, ?, ?, ?, ?)")) {

            try (Statement clear = con.createStatement()) {
                clear.executeUpdate("DELETE FROM bus_pass");
            }

            long start = System.nanoTime();
            for (int i = 1; i <= 10; i++) {
                ps.setString(1, "P" + i);
                ps.setString(2, "192400" + i);
                ps.setString(3, "Student" + i);
                ps.setInt(4, 7);
                ps.setDouble(5, 3800.0);
                ps.executeUpdate();
            }
            long end = System.nanoTime();
            System.out.println("PreparedStatement 10 rows time(ms) = " + ((end-start)/1_000_000.0));
        }
    }
}
