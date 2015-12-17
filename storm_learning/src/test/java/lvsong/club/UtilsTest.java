package lvsong.club;

import org.junit.Test;

import java.util.Random;

/**
 * Created by lvsong on 11/30/15.
 */
public class UtilsTest {
    @Test
    public void randomTest() {
        int range = 5;

        Random random = new Random();
        for( int i = 0; i < range; i ++) {
            System.out.print(random.nextInt(range));
        }
    }
}
