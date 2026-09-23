package io.github.egorshramko.cbs.service;

import java.time.LocalDate;

import io.github.egorshramko.cbs.dto.sessions.MovieSessionResponse;

public interface SessionService {
    MovieSessionResponse getMovieSessionByDate(Long movieId, LocalDate sessionDate); 
}
