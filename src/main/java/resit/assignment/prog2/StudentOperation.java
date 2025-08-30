import java.util.ArrayList;
import java.util.Scanner;

public class StudentOperation {
    private StudentCollection studentCollection;
    private Scanner scanner;

    public StudentOperation(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter gender (M/F): ");
        char gender = scanner.nextLine().charAt(0);
        System.out.print("Enter grade (1-5): ");
        int grade = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter year of admission: ");
        String yearOfAdmission = scanner.nextLine();
        System.out.print("Enter year of graduation: ");
        String yearOfGraduation = scanner.nextLine();

        Student student = new Student(studentID, studentName, age, gender, grade, 
                                     yearOfAdmission, yearOfGraduation);
        studentCollection.getStudents().add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String studentID = scanner.nextLine();
        ArrayList<Student> students = studentCollection.getStudents();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                students.remove(i);
                System.out.println("Student removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("This ID does not exist.");
        }
    }

    public void updateStudentDetails() {
        System.out.print("Enter student ID to update: ");
        String studentID = scanner.nextLine();
        ArrayList<Student> students = studentCollection.getStudents();
        Student student = null;

        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            System.out.println("This ID does not exist.");
            return;
        }

        System.out.print("Enter new name (or null to skip): ");
        String newName = scanner.nextLine();
        if (!newName.equals("null")) {
            student.setStudentName(newName);
        }

        System.out.print("Enter new age (or 0 to skip): ");
        int newAge = Integer.parseInt(scanner.nextLine());
        if (newAge != 0) {
            student.setAge(newAge);
        }

        System.out.print("Enter new gender (M/F, or 'N' to skip): ");
        String genderInput = scanner.nextLine();
        if (!genderInput.equals("N")) {
            student.setGender(genderInput.charAt(0));
        }

        System.out.print("Enter new grade (1-5, or 0 to skip): ");
        int newGrade = Integer.parseInt(scanner.nextLine());
        if (newGrade != 0) {
            student.setGrade(newGrade);
        }

        System.out.print("Enter new year of admission (or null to skip): ");
        String newYearOfAdmission = scanner.nextLine();
        if (!newYearOfAdmission.equals("null")) {
            student.setYearOfAdmission(newYearOfAdmission);
        }

        System.out.print("Enter new year of graduation (or null to skip): ");
        String newYearOfGraduation = scanner.nextLine();
        if (!newYearOfGraduation.equals("null")) {
            student.setYearOfGraduation(newYearOfGraduation);
        }

        System.out.println("Student details updated successfully.");
    }

    public void searchStudentByID() {
        System.out.print("Enter student ID to search: ");
        String studentID = scanner.nextLine();
        ArrayList<Student> students = studentCollection.getStudents();
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("This ID does not exist.");
        }
    }

    public void printGraduateStudents() {
        Graduates graduates = new Graduates(studentCollection);
        graduates.printGraduates();
    }
}