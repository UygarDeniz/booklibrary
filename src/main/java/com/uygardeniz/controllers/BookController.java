package com.uygardeniz.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uygardeniz.dto.ApiResponse;
import com.uygardeniz.dto.DtoBook;
import com.uygardeniz.dto.DtoBookIU;

import com.uygardeniz.models.Book;

import com.uygardeniz.services.interfaces.IBookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping
    public ApiResponse<List<DtoBook>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<DtoBook> response = new ArrayList<>();
        for (Book book : books) {
            String authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();

            DtoBook dtoBook = new DtoBook(book.getId(), book.getTitle(), authorName, book.getGenres());
            response.add(dtoBook);
        }

        ApiResponse<List<DtoBook>> res = new ApiResponse<List<DtoBook>>(HttpStatus.OK.value(),
                "Books fetched successfully",
                response);
        return res;
    }

    @GetMapping("/{id}")
    public ApiResponse<DtoBook> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        String authorName = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
        DtoBook dtoBook = new DtoBook(book.getId(), book.getTitle(), authorName, book.getGenres());
        ApiResponse<DtoBook> res = new ApiResponse<DtoBook>(HttpStatus.OK.value(), "Book fetched successfully",
                dtoBook);
        return res;
    }

    @PostMapping
    public ApiResponse<DtoBook> createBook(@Valid @RequestBody DtoBookIU book) {
        Book newBook = bookService.createBook(book.getTitle(), book.getAuthor_id(), book.getGenres());
        String authorName = newBook.getAuthor().getFirstName() + " " + newBook.getAuthor().getLastName();
        DtoBook dtoBook = new DtoBook(newBook.getId(), newBook.getTitle(), authorName, newBook.getGenres());
        ApiResponse<DtoBook> res = new ApiResponse<DtoBook>(HttpStatus.CREATED.value(), "Book created successfully",
                dtoBook);
        return res;
    }

    @PutMapping("/{id}")
    public ApiResponse<DtoBook> updateBook(@Valid @PathVariable Long id, @RequestBody DtoBookIU book) {

        Book newBook = bookService.updateBook(id, book.getTitle(), book.getAuthor_id(), book.getGenres());

        String authorName = newBook.getAuthor().getFirstName() + " " + newBook.getAuthor().getLastName();
        DtoBook dtoBook = new DtoBook(newBook.getId(), newBook.getTitle(), authorName, newBook.getGenres());
        ApiResponse<DtoBook> res = new ApiResponse<DtoBook>(HttpStatus.OK.value(), "Book updated successfully",
                dtoBook);
        return res;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        ApiResponse<Void> res = new ApiResponse<Void>(HttpStatus.OK.value(), "Book deleted successfully", null);
        return res;
    }

}
