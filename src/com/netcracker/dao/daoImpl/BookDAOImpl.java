package com.netcracker.dao.daoImpl;


import com.netcracker.dao.BasicDAO;
import com.netcracker.dao.iDAO.IBookDAO;
import com.netcracker.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BasicDAO implements IBookDAO {
    @Override
    public void saveBook(Book book) {
        persist(book);
    }

    @Override
    public List<Book> findAllBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list();
    }

    @Override
    public Book findBookById(int id) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("book_id", id));
        return (Book) criteria.uniqueResult();
    }

    @Override
    public void deleteBookById(int id) {
        Query query = getSession().createQuery("delete from Book where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
