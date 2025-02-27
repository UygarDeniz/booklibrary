package com.uygardeniz.services.interfaces;

import java.util.List;

import com.uygardeniz.models.Book;

public interface IBookService {
    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public Book createBook(String title, Long authorId, List<Long> genreIds);

    public Book updateBook(Long id, String title, Long authorId, List<Long> genreIds);

    public void deleteBook(Long id);
}
