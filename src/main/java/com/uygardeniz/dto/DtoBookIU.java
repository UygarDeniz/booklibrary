package com.uygardeniz.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DtoBookIU {

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @NotNull(message = "Author is required")
    private Long author_id;

    @NotEmpty(message = "At least one genre is required")
    private List<Long> genres;

    public DtoBookIU() {
    }

    public DtoBookIU(Long id, String title, Long author_id, List<Long> genres) {
        this.id = id;
        this.title = title;
        this.author_id = author_id;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public List<Long> getGenres() {
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "DtoBook [id=" + id + ", title=" + title + ", author_id=" + author_id + ", genres=" + genres + "]";
    }

}
