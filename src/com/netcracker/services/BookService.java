package com.netcracker.services;

import com.netcracker.dao.iDAO.IBookDAO;
import com.netcracker.model.Book;
import com.netcracker.services.iServices.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;

    @Override
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookDAO.findBookById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }
    @Override
    public void updateBook(Book book) { bookDAO.updateBook(book);}
}
