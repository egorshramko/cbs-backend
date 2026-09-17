package io.github.egorshramko.cbs.dto.sessions;

import java.util.List;

public record CinemaDescription(
    Long id,
    String name,
    String imageUrl,
    String city,
    String address,
    CinemaFeatures features,
    List<HallSession> hallSessions
) {}
