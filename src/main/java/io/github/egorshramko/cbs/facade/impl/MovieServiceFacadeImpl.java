package io.github.egorshramko.cbs.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.egorshramko.cbs.dto.MovieDto;
import io.github.egorshramko.cbs.facade.MovieServiceFacade;
import io.github.egorshramko.cbs.model.Movie;
import io.github.egorshramko.cbs.service.MovieService;
import io.github.egorshramko.cbs.util.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovieServiceFacadeImpl implements MovieServiceFacade {

    private final MovieMapper movieMapper;
    private final MovieService movieService;

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieDto> movieDtos = new ArrayList<>(movies.size());

        for (Movie movie : movies) {
            
            String imageUrl = movie.getPosterFilename(); //TODO: переделать на запрос к S3-хранилищу
            MovieDto movieDto = movieMapper.toDto(movie, imageUrl);
            movieDtos.add(movieDto);

        }

        return movieDtos;
    }



}
