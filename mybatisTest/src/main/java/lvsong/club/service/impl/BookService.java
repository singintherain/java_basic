package lvsong.club.service.impl;

import lvsong.club.model.mapper.BooksMapper;
import lvsong.club.model.pojo.Books;
import lvsong.club.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvsong on 5/13/16.
 */
@Service
public class BookService implements IBookService {
    @Autowired
    BooksMapper booksMapper;

    @Override
    public void create(Books books) {
        booksMapper.insert(books);
    }
}
