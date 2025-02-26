package com.uygardeniz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uygardeniz.dto.DtoBook;
import com.uygardeniz.dto.DtoBookInsert;
import com.uygardeniz.models.Author;
import com.uygardeniz.models.Book;
import com.uygardeniz.models.Genre;
import com.uygardeniz.services.interfaces.IAuthorService;
import com.uygardeniz.services.interfaces.IBookService;
import com.uygardeniz.services.interfaces.IGenreService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {

    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IGenreService genreService;

    public BookController(IBookService bookService, IAuthorService authorService, IGenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping
    public List<DtoBook> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<DtoBook> response = new ArrayList<>();
        for (Book book : books) {
            String authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();

            DtoBook dtoBook = new DtoBook(book.getId(), book.getTitle(), authorName, book.getGenres());
            response.add(dtoBook);
        }
        return response;
    }

    @PostMapping
    public DtoBook createBook(@RequestBody DtoBookInsert book) {
        Author author = authorService.getAuthorById(book.getAuthor_id());
        
        // Update later for error handling
        if (author == null) {
            return null;
        }
        
        List<Genre> genres = genreService.getGenresByIds(book.getGenres());
        Book newBook = new Book(book.getTitle(), author, genres);
        
        newBook = bookService.saveBook(newBook);

        String authorName = newBook.getAuthor().getFirstName() + " " + newBook.getAuthor().getLastName();
        return new DtoBook(newBook.getId(), newBook.getTitle(), authorName, newBook.getGenres());
    }

}
