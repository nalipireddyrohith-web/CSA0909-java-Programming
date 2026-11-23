import java.sql.*;

public class StatementTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/csa09_assignment5";
        try (Connection con = DriverManager.getConnection(url, "root", "YOUR_PASSWORD");
             Statement st = con.createStatement()) {

            st.executeUpdate("DELETE FROM bus_pass");
            long start = System.nanoTime();

            for (int i = 1; i <= 10; i++) {
                st.executeUpdate("INSERT INTO bus_pass(pass_id, reg_no, name, route_no, amount) VALUES " +
                        "('S" + i + "','192400" + i + "','Student" + i + "',7,3800.0)");
            }

            long end = System.nanoTime();
            System.out.println("Statement 10 rows time(ms) = " + ((end-start)/1_000_000.0));

            try (ResultSet rs = st.executeQuery("SELECT * FROM bus_pass");
                 ) {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.println(md.getColumnName(i) + " : " + md.getColumnTypeName(i));
                }
            }
        }
    }
}
