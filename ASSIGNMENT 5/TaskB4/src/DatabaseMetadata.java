import java.sql.*;
import java.util.*;

public class DatabaseMetadata {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";

        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD")) {
            DatabaseMetaData md = con.getMetaData();

            System.out.println("Database product = " + md.getDatabaseProductName());
            System.out.println("Database version = " + md.getDatabaseProductVersion());
            System.out.println("Driver name = " + md.getDriverName());
            System.out.println("Driver version = " + md.getDriverVersion());

            try (ResultSet rs = md.getTables(null, null, "%", new String[]{"TABLE"})) {
                while (rs.next()) {
                    System.out.println("Table = " + rs.getString("TABLE_NAME"));
                }
            }
        }
    }
}
