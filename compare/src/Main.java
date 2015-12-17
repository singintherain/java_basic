import java.util.*;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("student1", 2, 9);
        Student student2 = new Student("student2", 3, 8);
        Student student3 = new Student("student3", 4, 3);
        Student student4 = new Student("student4", 7, 5);
        Student student5 = new Student("student5", 4, 4);
        Student student6 = new Student("student6", 9, 6);
        Student student7 = new Student("student7", 1, 1);

        List<Student> students = new ArrayList<Student>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        System.out.println(students.size());

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

//        Collections.sort(students, (c1, c2) -> c1.getAge() - c2.getAge());

        for(Student student : students) {
            System.out.println(student);
        }
    }
}
