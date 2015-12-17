/**
 * Created by lvsong on 11/28/15.
 */
public class AnonymizeClass {

    private abstract class Student {
        int number;
        private int age;
        public Student(int age) {
            this.age = age;
        }

        abstract public void hello();
    }

    public Student student(int age, final String message) {
        return new Student(age) {
            public void hello() {
                System.out.print(message);
            }
        };
    }

    public static void main(String[] args) {
        AnonymizeClass anonymizeClass = new AnonymizeClass();
        AnonymizeClass.Student student = anonymizeClass.student(3, "hello");
    }
}

