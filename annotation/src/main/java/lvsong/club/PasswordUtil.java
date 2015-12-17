package lvsong.club;

/**
 * Created by lvsong on 11/4/15.
 */
public class PasswordUtil {
    @UseCaseAnnotation(id = 1, descrption = "验证密码是否正确")
    public boolean validatePassword() {
        System.out.println("验证密码是否正确");

        return false;
    }

    @UseCaseAnnotation(id = 2, descrption = "加密密码")
    public void encryPassword() {
        System.out.println("加密密码");
    }

    @UseCaseAnnotation(id = 3, descrption = "验证是否是新密码")
    public boolean checkForNewPassword() {
        System.out.println("验证是否是新密码");

        return false;
    }
}
