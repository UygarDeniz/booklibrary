package com.uygardeniz.services.interfaces;

import java.util.List;

import com.uygardeniz.models.Book;

public interface IBookService {
    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public Book saveBook(Book book);

    public Book updateBook(Book book);

    public void deleteBook(Long id);
}
