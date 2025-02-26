package com.uygardeniz.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.uygardeniz.models.Genre;
import com.uygardeniz.repository.GenreRepository;
import com.uygardeniz.services.interfaces.IGenreService;

@Service
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> getGenresByIds(List<Long> ids) {
        return genreRepository.findAllById(ids);
    }
}