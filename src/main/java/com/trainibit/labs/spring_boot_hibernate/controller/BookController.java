package com.trainibit.labs.spring_boot_hibernate.controller;

import com.trainibit.labs.spring_boot_hibernate.model.Book;
import com.trainibit.labs.spring_boot_hibernate.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("bookstore/v1/")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("saveBook")
    public ResponseEntity<Book> save (@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<Book>(book, null, HttpStatus.CREATED);
    }

    @GetMapping("getBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("getBook/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PutMapping("updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        try
        {
           bookService.updateBook(book);
           return new ResponseEntity<Book>(book,null, HttpStatus.OK);

        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
    {
        try
        {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
