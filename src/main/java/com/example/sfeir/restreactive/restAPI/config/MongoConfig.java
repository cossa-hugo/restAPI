package com.example.sfeir.restreactive.restAPI.config;

import com.example.sfeir.restreactive.restAPI.document.Book;
import com.example.sfeir.restreactive.restAPI.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = BookRepository.class)
@Configuration
public class MongoConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return strings -> {
            bookRepository.save(new Book("s8kJ38j", "Harry potter", "JK ROWLING", 39, 1));
            bookRepository.save(new Book("9,kdhiyhdkçà", "Dark side of the moon", "Petter Gabson", 37, 0));
        };
    }

}
