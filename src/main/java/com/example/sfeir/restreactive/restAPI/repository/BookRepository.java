package com.example.sfeir.restreactive.restAPI.repository;

import com.example.sfeir.restreactive.restAPI.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

}
