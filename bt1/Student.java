package bt1;

public class Student {
    public String fullName;
    public int age;
    public int GPA;

    public Student(String fullName, int age, int GPA) {
        this.fullName = fullName;
        this.age = age;
        this.GPA = GPA;
    }
    private String getLastName(String fullName) {
        String[] parts = fullName.split(" ");
        return parts[parts.length - 1];
    }
    public void sortStudentByName(Student[] students){
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1; j++) {
                Student st1 = students[j];
                Student st2 = students[j+1];
                if (st1.fullName.compareTo(st2.fullName) > 0  ||
                        (st1.fullName.equals(st2.fullName) && st1.age < st2.age)) {
                    // Đổi chỗ nếu st1.fullName lớn hơn hoặc tên giống nhau và st1 tuổi nhỏ hơn st2
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public void sortByAgeAndGPA(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                Student s1 = students[j];
                Student s2 = students[j + 1];

                // So sánh age và nếu bằng tuổi thì so sánh GPA
                if (s1.age > s2.age || (s1.age == s2.age && s1.GPA < s2.GPA)) {
                    // Đổi chỗ nếu s1 tuổi lớn hơn hoặc tuổi bằng nhau và GPA nhỏ hơn
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public void sortByLastName(Student[] students){
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                String lastName1 = getLastName(students[j].fullName);
                String lastName2 = getLastName(students[j + 1].fullName);

                // So sánh dựa trên tên cuối cùng
                if (lastName1.compareTo(lastName2) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
