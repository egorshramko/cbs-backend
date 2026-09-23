package io.github.egorshramko.cbs.dto.sessions;

import java.util.List;

public record CinemaSessions(
    Long id,
    String name,
    String imageUrl,
    String city,
    String address,
    CinemaFeatures features,
    List<HallSession> hallSessions
) {}
