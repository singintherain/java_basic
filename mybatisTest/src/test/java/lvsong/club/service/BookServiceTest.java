package lvsong.club.service;

import lvsong.club.model.pojo.Books;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvsong on 5/13/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class BookServiceTest {
    @Autowired
    IBookService bookService;

    @Test
    public void createTest() {
        Books books = new Books();
        books.setAuthorName("test");
        books.setCreateTime(DateTime.now());
        books.setAuthorId(2);

        bookService.create(books);
    }
}
