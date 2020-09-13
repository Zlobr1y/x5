package Task3;

public class Main {
    public static void main(String[] args) {
        Student[] students = {new Student(), new Aspirant()};

        students[0].setAvgMark(4.9);
        students[0].setLastName("Flash Thompson");
        students[1].setAvgMark(5);
        students[1].setLastName("Peter Parker");

        for(Student student: students){
            System.out.println(student.getLastName()+ " " + student.getScholarship());
        }
    }
}
