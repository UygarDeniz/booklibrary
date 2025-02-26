package com.uygardeniz.services.interfaces;

import java.util.List;

import com.uygardeniz.models.Author;

public interface IAuthorService {
    public List<Author> getAllAuthors();

    public Author getAuthorById(Long id);

    public Author saveAuthor(Author author);

    public Author updateAuthor(Author author);

    public void deleteAuthor(Long id);
}
