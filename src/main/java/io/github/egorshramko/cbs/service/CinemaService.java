package io.github.egorshramko.cbs.service;

import java.util.List;

import io.github.egorshramko.cbs.dto.CinemaDto;

public interface CinemaService {
    List<CinemaDto> getAllCinemas();
}
