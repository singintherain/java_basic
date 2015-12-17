package lvsong.club;

import org.junit.Test;

/**
 * Created by lvsong on 11/5/15.
 */
public class TableCreatorTest {
    @Test
    public void createTest() throws Exception {
        String classFileName = "lvsong.club.Member";

        TableCreator tableCreator = new TableCreator();

        tableCreator.create(classFileName);
    }
}
