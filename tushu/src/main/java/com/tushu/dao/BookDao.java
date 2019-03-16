package com.tushu.dao;

import com.tushu.bean.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public interface BookDao {
        int add(Book book);
        int delete(int id);
        int update(Book book);
        Book select(int id);
        List<Book> selectAll();
}
