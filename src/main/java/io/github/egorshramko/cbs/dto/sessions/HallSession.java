package io.github.egorshramko.cbs.dto.sessions;

import java.util.List;

import io.github.egorshramko.cbs.dto.SessionDto;

public record HallSession(
    String hallName,
    List<String> hallMovieFormats,
    List<SessionDto> sessions
) {}
