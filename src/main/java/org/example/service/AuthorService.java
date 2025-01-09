package org.example.service;

import org.example.exception.AuthorException;
import org.example.model.response.book.AuthorResponse;
import org.example.repository.AuthorRepository;
import org.example.repository.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponse getAuthorById(Integer authorId) {
        Author author = this.authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorException("AUTHOR_1001", String.format("Author with ID %s not found", authorId)));

        return new AuthorResponse(authorId, author.getFirstname(), author.getLastname());
    }
}
