package com.trainibit.labs.spring_boot_hibernate.service.impl;

import com.trainibit.labs.spring_boot_hibernate.model.Book;
import com.trainibit.labs.spring_boot_hibernate.service.BookService;
import com.trainibit.labs.spring_boot_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void saveBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Book> books = session.createQuery("from Book", Book.class).getResultList();
        return books;
    }

    @Override
    public Book getBookById(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        transaction.commit();
        return book;
    }

    @Override
    public void updateBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();

    }

    @Override
    public void deleteBook(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        if (book != null) {
            session.delete(book);
        }
        transaction.commit();
    }
}
