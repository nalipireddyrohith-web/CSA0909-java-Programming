import java.sql.*;
import java.util.*;

public class BatchTest {
    static List<String[]> generate(int n) {
        List<String[]> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(new String[]{"B" + i, "1925" + String.format("%06d", i),
                    "Student" + i, "7", "3800.0"});
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        int n = args.length == 0 ? 1000 : Integer.parseInt(args[0]);
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";

        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD")) {
            try (Statement clear = con.createStatement()) {
                clear.executeUpdate("DELETE FROM bus_pass");
            }

            long start = System.nanoTime();
            int count = PassLoader.loadAll(con, generate(n));
            long end = System.nanoTime();

            System.out.println("Batch rows = " + count);
            System.out.println("Batch time(ms) = " + ((end-start)/1_000_000.0));

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM bus_pass")) {
                rs.next();
                System.out.println("Rows in table = " + rs.getInt(1));
            }
        }
    }
}
