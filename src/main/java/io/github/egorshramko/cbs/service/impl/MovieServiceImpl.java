package io.github.egorshramko.cbs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.egorshramko.cbs.exceptions.EntityNotFoundException;
import io.github.egorshramko.cbs.model.Movie;
import io.github.egorshramko.cbs.repository.MovieRepository;
import io.github.egorshramko.cbs.service.MovieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));
    }

    

}
