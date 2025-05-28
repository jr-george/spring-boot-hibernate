package com.trainibit.labs.spring_boot_hibernate.service;

import com.trainibit.labs.spring_boot_hibernate.model.Book;
import java.util.List;
public interface BookService {
    void saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    void updateBook(Book book);
    void deleteBook(long id);
}
