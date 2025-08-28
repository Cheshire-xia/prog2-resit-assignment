public class Student {
    private String studentID;
    private String studentName;
    private int age;
    private char gender;
    private int grade;
    private String yearOfAdmission;
    private String yearOfGraduation;

    // 构造函数
    public Student(String studentID, String studentName, int age, char gender, int grade, 
                   String yearOfAdmission, String yearOfGraduation) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.yearOfAdmission = yearOfAdmission;
        this.yearOfGraduation = yearOfGraduation;
    }

    // Getter 和 Setter 方法
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    public String getYearOfAdmission() { return yearOfAdmission; }
    public void setYearOfAdmission(String yearOfAdmission) { this.yearOfAdmission = yearOfAdmission; }

    public String getYearOfGraduation() { return yearOfGraduation; }
    public void setYearOfGraduation(String yearOfGraduation) { this.yearOfGraduation = yearOfGraduation; }

    // toString 方法
    @Override
    public String toString() {
        return studentID + " " + studentName + " " + age + " " + gender + " " + 
               grade + " " + yearOfAdmission + " " + yearOfGraduation;
    }
}
