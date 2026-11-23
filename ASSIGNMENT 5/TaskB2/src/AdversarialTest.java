import java.sql.*;

public class AdversarialTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5_security";
        String user = "root";
        String password = "YOUR_PASSWORD";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String attack = "' OR '1'='1";
            System.out.println("Unsafe result = " + UnsafeLogin.login(con, "not-a-user", attack));
            System.out.println("PreparedStatement result = " + SafeLogin.login(con, "not-a-user", attack));
        }
    }
}
