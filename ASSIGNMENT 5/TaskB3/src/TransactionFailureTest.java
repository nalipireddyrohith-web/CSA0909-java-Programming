import java.sql.*;

public class TransactionFailureTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";

        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD")) {
            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bus_pass(pass_id, reg_no, name, route_no, amount) VALUES (?, ?, ?, ?, ?)")) {

                for (int i = 1; i <= 20; i++) {
                    ps.setString(1, "F" + i);
                    ps.setString(2, "1930" + i);
                    ps.setString(3, "FailureTest" + i);
                    ps.setInt(4, 7);
                    ps.setDouble(5, i == 10 ? -1 : 3800.0);

                    if (i == 10) {
                        throw new IllegalArgumentException("Forced invalid amount at row 10");
                    }

                    ps.executeUpdate();
                }

                con.commit();
            } catch (Exception e) {
                con.rollback();
                System.out.println("Failure: " + e.getMessage());
                System.out.println("Transaction rolled back.");
            } finally {
                con.setAutoCommit(true);
            }
        }
    }
}
