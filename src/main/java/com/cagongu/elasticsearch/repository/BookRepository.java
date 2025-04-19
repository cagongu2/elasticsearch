package com.cagongu.elasticsearch.repository;

import com.cagongu.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface BookRepository extends ElasticsearchRepository<Book, String> {
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\", \"author\", \"description\",  \"genre\", \"publisher\"]}}")
    List<Book> searchBooks(String query);
}