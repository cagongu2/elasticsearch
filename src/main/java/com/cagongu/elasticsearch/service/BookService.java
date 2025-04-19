package com.cagongu.elasticsearch.service;

import com.cagongu.elasticsearch.entity.Book;
import com.cagongu.elasticsearch.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchOperations operations;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveAll(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.searchBooks(query);
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    public long count() {
        return bookRepository.count();
    }
}
