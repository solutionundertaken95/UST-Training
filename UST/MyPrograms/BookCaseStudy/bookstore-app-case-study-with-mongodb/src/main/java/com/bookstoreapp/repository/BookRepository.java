package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book,Integer> {
}
