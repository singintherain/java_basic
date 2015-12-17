package lvsong.club;

/**
 * Created by lvsong on 11/5/15.
 */
@DBTable(name = "members")
public class Member {
    @SQLString(30)
    private String firstName;

    @SQLString(50)
    private String lastName;

    @SQLInteger
    private int age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }
}
