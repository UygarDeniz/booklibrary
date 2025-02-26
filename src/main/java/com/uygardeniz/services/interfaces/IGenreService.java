package com.uygardeniz.services.interfaces;

import java.util.List;
import com.uygardeniz.models.Genre;

public interface IGenreService {
    Genre getGenreById(Long id);
    List<Genre> getGenresByIds(List<Long> ids);
}