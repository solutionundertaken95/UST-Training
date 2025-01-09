package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    // GET : /books
    // Return Response code of 200
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookstoreService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookList);

    }



    // POST : /books
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookstoreService.saveBook(book);

    }

    // create a PUT request to update a book
    // Return Response code of 202

   // PUT: /books/{id}
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {

        Book book1 = bookstoreService.updateBook(id,book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(book1);

    }

    // create a DELETE request to delete a book
    // Return Response code of 204

    // DELETE : /books/{id}
    @DeleteMapping("/books/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public void deleteBook(@PathVariable int id) {
            bookstoreService.deleteBook(id);

    }


    // create a GET request to get a book by id
    // Return Response code of 200

    // GET: /books/{id}
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookstoreService.getBookById(id);
        //return ResponseEntity.status(HttpStatus.OK).body(book);

        return ResponseEntity.ok().body(book);


    }




}
