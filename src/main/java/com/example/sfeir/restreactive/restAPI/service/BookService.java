package com.example.sfeir.restreactive.restAPI.service;

import com.example.sfeir.restreactive.restAPI.document.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Flux<Book> getAll();
    Flux<Book> findAllByAuthor(String author);
    Mono<Book> getById(String id);
    Mono<Book> save(Book book);
    Mono<Void> deleteById(String id);
}
