package com.tushu.service.impl;

import com.tushu.bean.Book;
import com.tushu.dao.BookDao;
import com.tushu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean add(Book book) {
        return bookDao.add(book)>0;
    }

    @Override
    public int delete(int id) {
        return bookDao.delete(id);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book select(int id) {
        return bookDao.select(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }
}
