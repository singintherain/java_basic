import java.util.Comparator;

/**
 * Created by lvsong on 7/7/15.
 */
public class Student {
    private int age;
    private int height;
    private String name;

    public Student() {}

    public Student(String name, int age, int height) {
        this.setAge(age);
        this.setHeight(height);
        this.setName(name);
    }

    public String toString() {
        return getName() + "-" + getAge() + "-" + getHeight();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
