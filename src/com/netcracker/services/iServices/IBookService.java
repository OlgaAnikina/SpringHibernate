package com.netcracker.services.iServices;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookService {
    void saveBook(Book book);
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteBookById(int id);

}
