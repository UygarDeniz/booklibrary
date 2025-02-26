package com.uygardeniz.dto;

import java.util.List;

import com.uygardeniz.models.Genre;

public class DtoBook {

    
    private String title;
    private String author_name;
    private List<Genre> genres;

    public DtoBook() {
    }

    public DtoBook(Long id, String title, String author_name, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.author_name = author_name;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "DtoBook [id=" + id + ", title=" + title + ", author_name=" + author_name + ", genres=" + genres + "]";
    }

}
