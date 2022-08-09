package com.example.sfeir.restreactive.restAPI.repository;

import com.example.sfeir.restreactive.restAPI.document.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    @Tailable
    Flux<Book> findAllBy();
    @Tailable
    Flux<Book> findWithTailableCursorBy();
    Flux<Book> findAllByAuthor(String author);
}
