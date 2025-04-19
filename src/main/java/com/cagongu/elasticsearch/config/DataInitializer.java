package com.cagongu.elasticsearch.config;

import com.cagongu.elasticsearch.entity.Book;
import com.cagongu.elasticsearch.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;


    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            long currentBookCount = bookService.count();
            if (currentBookCount >= 10) {
                System.out.println("Already have " + currentBookCount + " books. Skipping import to avoid duplicates.");
                return;
            }
            InputStream inputStream = new ClassPathResource("books.json").getInputStream();
            List<Book> books = objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {
            });

            bookService.saveAll(books);

            System.out.println("Imported " + books.size() + " books into Elasticsearch.");
        };
    }
}
