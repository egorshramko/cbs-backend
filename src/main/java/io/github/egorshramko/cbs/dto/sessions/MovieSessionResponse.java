package io.github.egorshramko.cbs.dto.sessions;

import java.util.List;

public record MovieSessionResponse(
    List<CinemaDescription> cinemas
) {}
