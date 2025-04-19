package com.cagongu.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "book-index")
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String author;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Keyword)
    private String genre;

    @Field(type = FieldType.Date)
    private LocalDate publicationDate;

    @Field(type = FieldType.Text)
    private String publisher;

    @Field(type = FieldType.Integer)
    private Integer pageCount;

    @Field(type = FieldType.Keyword)
    private String isbn;

    @Field(type = FieldType.Keyword)
    private String language;

    @Field(type = FieldType.Boolean)
    private Boolean inStock;
}