package com.example.sfeir.restreactive.restAPI.controller;

import com.example.sfeir.restreactive.restAPI.document.Book;
import com.example.sfeir.restreactive.restAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> getItemById(@PathVariable String id) {
        return this.bookService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> save(@RequestBody @Validated Book book) {
        return this.bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteItemById(@PathVariable String id) {
        return this.bookService.deleteById(id);
    }

}
