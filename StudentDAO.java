import java.sql.*;
import java.util.Scanner;
public class StudentDAO {
    static Scanner sc = new Scanner(System.in);
    public static void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, student.getPrn());
            pst.setString(2, student.getName());
            pst.setString(3, student.getDob());
            pst.setDouble(4, student.getMarks());
            pst.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }
    public static void displayStudents() throws SQLException {
        String query = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("PRN: " + rs.getString("prn") + ", Name: " + rs.getString("name")
                        + ", DoB: " + rs.getString("dob") + ", Marks: " + rs.getDouble("marks"));
            }
        }
    }
}