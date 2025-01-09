package org.example.model.request.book;

import lombok.Data;

@Data
public class BookInput {
    private String title;
    private double price;
    private int pages;
    private AuthorInput author;
}
