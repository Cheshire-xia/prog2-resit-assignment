import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentCollection {
    private ArrayList<Student> students;

    // 构造函数
    public StudentCollection() {
        students = new ArrayList<>();
    }

    // Getter 方法
    public ArrayList<Student> getStudents() {
        return students;
    }

    // 读取 CSV 文件并添加到 students ArrayList
    public void addStudents(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 跳过标题行
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    Student student = new Student(
                        data[0].trim(), // studentID
                        data[1].trim(), // studentName
                        Integer.parseInt(data[2].trim()), // age
                        data[3].trim().charAt(0), // gender
                        Integer.parseInt(data[4].trim()), // grade
                        data[5].trim(), // yearOfAdmission
                        data[6].trim()  // yearOfGraduation
                    );
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // toString 方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }
}