import java.sql.*;
import java.util.Scanner;
public class StudentDAO {
    static Scanner sc = new Scanner(System.in);
    public static void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students_info (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
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
        String query = "SELECT * FROM students_info";
        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("PRN: " + rs.getString("prn") + ", Name: " + rs.getString("name")
                        + ", DoB: " + rs.getString("dob") + ", Marks: " + rs.getDouble("marks"));
            }
        }
    }
    public static void searchByPRN(String prn) throws SQLException {
        String query = "SELECT * FROM students_info WHERE prn=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, prn);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Found: " + rs.getString("name") + ", " + rs.getString("dob") + ", " + rs.getDouble("marks"));
            } else {
                System.out.println("Student not found.");
            }
        }
    }
    public static void updateStudent(String prn) throws SQLException {
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new DoB: ");
        String dob = sc.nextLine();
        System.out.print("Enter new marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        String query = "UPDATE students_info SET name=?, dob=?, marks=? WHERE prn=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, dob);
            pst.setDouble(3, marks);
            pst.setString(4, prn);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated.");
            else
                System.out.println("Student not found.");
        } 
    } 
    public static void deleteStudent(String prn) throws SQLException {
        String query = "DELETE FROM students_info WHERE prn=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, prn);
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted.");
            else
                System.out.println("Student not found.");
        }
    }
}