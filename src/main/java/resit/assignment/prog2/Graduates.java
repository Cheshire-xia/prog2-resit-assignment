import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;

public class Graduates {
    private StudentCollection studentCollection;

    public Graduates(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }

    public void printGraduates() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("GraduateStudents.txt"))) {
            bw.write("Following students have graduated so far.\n");
            bw.write("Student ID Student Name Age Gender Year of Admission Year of Graduation\n");

            int currentYear = Year.now().getValue();
            for (Student student : studentCollection.getStudents()) {
                try {
                    int gradYear = Integer.parseInt(student.getYearOfGraduation());
                    if (gradYear <= currentYear) {
                        bw.write(student.toString() + "\n");
                    }
                } catch (NumberFormatException e) {
                    // 跳过无效的毕业年份
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}