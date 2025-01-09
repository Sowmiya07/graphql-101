package org.example.model.response.book;

public record BookResponse(Integer id, String title, double price, int pages, AuthorResponse author) {}
