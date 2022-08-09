package com.example.sfeir.restreactive.restAPI.service;

import com.example.sfeir.restreactive.restAPI.document.Book;
import com.example.sfeir.restreactive.restAPI.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
@Log4j2
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public BookServiceImpl(BookRepository bookRepository, ReactiveMongoTemplate reactiveMongoTemplate){
        this.bookRepository = bookRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @PostConstruct
    public void setupCappedCollection() {
        this.reactiveMongoTemplate.dropCollection(Book.class)
                .then(this.reactiveMongoTemplate
                                        .createCollection(Book.class, CollectionOptions.empty()
                                        .capped()
                                        .size(40960000)
                                        .maxDocuments(1000000)))
                .subscribe();
    }

    @Override
    public Flux<Book> getAll() {
        log.info("Trying to get all items..");
        return this.bookRepository.findWithTailableCursorBy();
    }

    @Override
    public Flux<Book> findAllByAuthor(String author) {
        log.info("Trying to get all books from "+author+".");
        return this.bookRepository.findAllByAuthor(author);
    }

    @Override
    public Mono<Book> getById(String id) {
        log.info("Trying to get the book with id : "+id);
        return this.bookRepository.findById(id);
    }

    @Override
    public Mono<Book> save(Book book) {
        log.info("Save book :" + book.getTitle());
        return this.bookRepository.save(book);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        log.info("Delete book with id : " + id);
        return this.bookRepository.deleteById(id);
    }
}
