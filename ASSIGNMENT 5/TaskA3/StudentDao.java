import java.sql.*;
import java.util.*;

public class StudentDao implements Dao<Student, Integer> {
    private final Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO student(student_id, name, department) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, s.id());
            ps.setString(2, s.name());
            ps.setString(3, s.department());
            ps.executeUpdate();
        }
    }

    @Override
    public Student findById(Integer id) throws SQLException {
        String sql = "SELECT student_id, name, department FROM student WHERE student_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT student_id, name, department FROM student");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        return result;
    }

    @Override
    public void update(Student s) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE student SET name=?, department=? WHERE student_id=?")) {
            ps.setString(1, s.name());
            ps.setString(2, s.department());
            ps.setInt(3, s.id());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM student WHERE student_id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

record Student(int id, String name, String department) {}
interface Dao<T, K> {
    void insert(T value) throws Exception;
    T findById(K id) throws Exception;
    List<T> findAll() throws Exception;
    void update(T value) throws Exception;
    void delete(K id) throws Exception;
}
