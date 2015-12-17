package lvsong.club;

import org.junit.Test;

/**
 * Created by lvsong on 11/11/15.
 */
public class RmtShellExecutorTest {
    @Test
    public void executeTest() {
        RmtShellExecutor rmtShellExecutor = new RmtShellExecutor(
                "", "root", "", "22022");

        String command = "";

        try {
            rmtShellExecutor.execute(command);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
