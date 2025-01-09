package org.example.service;

import org.example.exception.BookException;
import org.example.model.request.book.BookInput;
import org.example.model.response.book.AuthorResponse;
import org.example.model.response.book.BookResponse;
import org.example.repository.BookRepository;
import org.example.repository.entity.Author;
import org.example.repository.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse getBookById(Integer bookId) throws BookException {
        Book book = this.bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookException("BOOK_1001", String.format("Book with ID %s is not found", bookId)));

        return new BookResponse(book.getId(), book.getTitle(), book.getPrice(), book.getPages(),
                book.getAuthor() != null ? new AuthorResponse(book.getAuthor().getId(), book.getAuthor().getFirstname(), book.getAuthor().getLastname()) : null);
    }

    public BookResponse createBook(BookInput bookInput) {

        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        book.setPages(bookInput.getPages());
        book.setPrice(bookInput.getPrice());

        if(bookInput.getAuthor() != null) {
            Author author = new Author();
            author.setFirstname(bookInput.getAuthor().getFirstname());
            author.setLastname(bookInput.getAuthor().getLastname());
            book.setAuthor(author);
        }

        Book savedBook = this.bookRepository.save(book);

        return new BookResponse(savedBook.getId(), savedBook.getTitle(), savedBook.getPrice(), savedBook.getPages(),
                savedBook.getAuthor() != null ?
                        new AuthorResponse(savedBook.getAuthor().getId(), savedBook.getAuthor().getFirstname(), savedBook.getAuthor().getLastname()) :
                        null);
    }
}
