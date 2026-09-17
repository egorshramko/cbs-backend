package io.github.egorshramko.cbs.dto.sessions;

public record CinemaFeatures(
    Integer hallsCount,
    Boolean imaxAvailable,
    Boolean parkingAvailable
) {}
