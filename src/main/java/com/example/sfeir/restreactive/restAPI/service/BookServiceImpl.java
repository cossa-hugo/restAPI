package com.example.sfeir.restreactive.restAPI.service;

import com.example.sfeir.restreactive.restAPI.document.Book;
import com.example.sfeir.restreactive.restAPI.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAll() {
        return bookRepository.findAll().switchIfEmpty(Flux.empty());
    }
    public Mono<Book> getById(final String id) {
        return bookRepository.findById(id);
    }
    public Mono update(final String id, final Book book) {
        return bookRepository.save(book);
    }
    public Mono save(final Book book) {
        return bookRepository.save(book);
    }

    public Mono delete(final String id) {
        final Mono<Book> bookDatabase = getById(id);
        if (Objects.isNull(bookDatabase)) {
            return Mono.empty();
        }
        return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(b -> bookRepository
                .delete(b).then(Mono.just(b)));
    }
}
