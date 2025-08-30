import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCollection studentCollection = new StudentCollection();
        studentCollection.addStudents("StudentDetails.csv");
        StudentOperation studentOperation = new StudentOperation(studentCollection);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View all students' details");
            System.out.println("2. Add new student");
            System.out.println("3. Search student details");
            System.out.println("4. Update student details");
            System.out.println("5. Remove student");
            System.out.println("6. Print graduate students");
            System.out.println("7. QUIT");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println(studentCollection);
                    break;
                case 2:
                    studentOperation.addStudent();
                    break;
                case 3:
                    studentOperation.searchStudentByID();
                    break;
                case 4:
                    studentOperation.updateStudentDetails();
                    break;
                case 5:
                    studentOperation.removeStudent();
                    break;
                case 6:
                    studentOperation.printGraduateStudents();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}