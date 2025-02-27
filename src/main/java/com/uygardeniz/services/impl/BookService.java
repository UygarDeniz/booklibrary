package com.uygardeniz.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uygardeniz.exceptions.ResourceNotFoundException;
import com.uygardeniz.models.Author;
import com.uygardeniz.models.Book;
import com.uygardeniz.repository.AuthorRepository;
import com.uygardeniz.repository.BookRepository;
import com.uygardeniz.repository.GenreRepository;
import com.uygardeniz.models.Genre;
import com.uygardeniz.services.interfaces.IBookService;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, GenreRepository genreRepository,
            AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public Book createBook(String title, Long authorId, List<Long> genreIds) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        List<Genre> genres = genreRepository.findAllById(genreIds);

        if (genres.size() != genreIds.size()) {
            throw new ResourceNotFoundException("One or more genres not found with given ids");
        }

        Book book = new Book(title, author, genres);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, String title, Long authorId, List<Long> genreIds) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        List<Genre> genres = genreRepository.findAllById(genreIds);

        if (genres.size() != genreIds.size()) {
            throw new ResourceNotFoundException("One or more genres not found with given ids");
        }

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenres(genres);

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
