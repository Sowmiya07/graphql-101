package org.example.controller;

import org.example.exception.BookException;
import org.example.model.response.book.AuthorResponse;
import org.example.model.response.book.BookResponse;
import org.example.model.request.book.BookInput;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public BookResponse bookById(@Argument Integer id) throws BookException {
        return this.bookService.getBookById(id);
    }

    @SchemaMapping
    public AuthorResponse author(BookResponse bookResponse) {
        return this.authorService.getAuthorById(bookResponse.author().id());
    }

    @MutationMapping
    public BookResponse createBook(@Argument BookInput input) {
        return this.bookService.createBook(input);
    }
}
