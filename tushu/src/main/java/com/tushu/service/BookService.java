package com.tushu.service;

import com.tushu.bean.Book;

import java.util.List;

public interface BookService {
    Boolean add(Book book);
    int delete(int id);
    int update(Book book);
    Book select(int id);
    List<Book> selectAll();
    List<Book> selectByCategoryId(int id);
}
