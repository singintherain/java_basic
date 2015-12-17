/**
 * Created by lvsong on 11/28/15.
 */
public class Student {
    private final int age;
    private final String name;

    private Student(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
    }

    public static class Builder {
        private int age = 0;
        private String name = "";

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public static void main(String[] args) {
        Student student = new Student.Builder().age(3).name("kitty").build();
    }
}
