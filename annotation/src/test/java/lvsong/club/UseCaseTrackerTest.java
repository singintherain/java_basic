package lvsong.club;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lvsong on 11/4/15.
 */
public class UseCaseTrackerTest {
    @Test
    public void runTest() {
        UseCaseTracker useCaseTracker = new UseCaseTracker();

        Assert.assertTrue(useCaseTracker.checkFromId(1, PasswordUtil.class));
    }
}
