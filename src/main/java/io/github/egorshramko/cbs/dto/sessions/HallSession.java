package io.github.egorshramko.cbs.dto.sessions;

import java.util.List;

import io.github.egorshramko.cbs.dto.SessionDto;
import io.github.egorshramko.cbs.model.enums.MovieFormat;

public record HallSession(
    String hallName,
    List<MovieFormat> hallMovieFormats,
    List<SessionDto> sessions
) {}
