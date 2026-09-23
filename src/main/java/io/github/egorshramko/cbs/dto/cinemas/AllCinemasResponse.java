package io.github.egorshramko.cbs.dto.cinemas;

import io.github.egorshramko.cbs.dto.CinemaDto;

import java.util.List;

public record AllCinemasResponse(
    List<CinemaDto> cinemas
) {}
