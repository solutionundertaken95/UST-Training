package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookstoreServiceImpl implements BookstoreService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @Override
    public Book getBookById(int id) {
        // Check if the book exists by ID
        if (bookRepository.existsById(id)) {
            // If the book exists, fetch and return the book
            return bookRepository.findById(id)
                    .orElseThrow(() -> new BookNotFoundException("Book not found"));
        } else {
            // If the book does not exist, throw an exception
            throw new BookNotFoundException("Book not found ");
        }
    }


    @Override
    public Book saveBook(Book book) {

        // check if book exists
        // if book exists throw exception book already exists
        // else save book

        if(bookRepository.existsById(book.getId())){
            throw new BookAlreadyExistsException("book already exists");
        }
        bookRepository.save(book);
        return book;

    }

    @Override
    public Book updateBook(int id, Book book) {

        // check if book exists
        // if book exists update book
        // else throw exception book not found

        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("book not found");
        }

        bookRepository.save(book);

        return book;


    }

    @Override
    public void deleteBook(int id) {

            // check if book exists
            // if book exists delete book
            // else throw exception book not found
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }
        else{
            throw new BookNotFoundException("book not found");
        }
    }


}
