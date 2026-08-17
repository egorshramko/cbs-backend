package io.github.egorshramko.cbs.facade;

import java.util.List;

import io.github.egorshramko.cbs.dto.MovieDto;

public interface MovieServiceFacade {
    List<MovieDto> getAllMovies();
}
