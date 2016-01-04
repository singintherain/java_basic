package lvsong.club.jdk;

/**
 * Created by lvsong on 1/3/16.
 */
public class Student {
    private String name;
    private Sex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String toString() {
        return "姓名: " + name + ", 性别: " + sex;
    }
}
