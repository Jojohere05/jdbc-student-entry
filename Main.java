import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        while (true) { 
            System.out.println("\n== Student Menu ==");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter PRN: ");
                        String prn = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter DoB: ");
                        String dob = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        sc.nextLine();
                        Student s = new Student(prn, name, dob, marks);
                        StudentDAO.addStudent(s);
                        break;
                    case 2:
                        StudentDAO.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter PRN: ");
                        StudentDAO.searchByPRN(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter PRN to update: ");
                        StudentDAO.updateStudent(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter PRN to delete: ");
                        StudentDAO.deleteStudent(sc.nextLine());
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } // consume newline
    } 
}
}