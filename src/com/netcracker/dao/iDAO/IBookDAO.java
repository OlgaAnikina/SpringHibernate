package com.netcracker.dao.iDAO;

import com.netcracker.model.Book;
import java.util.List;

public interface IBookDAO {
    void saveBook(Book entity);

    List<Book> findAllBooks();

    Book findBookById(int id);

    void deleteBookById(int id);

}
