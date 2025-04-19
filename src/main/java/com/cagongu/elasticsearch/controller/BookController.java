package com.cagongu.elasticsearch.controller;

import com.cagongu.elasticsearch.entity.Book;
import com.cagongu.elasticsearch.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        bookService.deleteById(id);
    }
}
