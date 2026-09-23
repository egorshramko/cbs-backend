package io.github.egorshramko.cbs.dto;

import java.time.LocalDateTime;

public record SessionDto(
    Long id,
    LocalDateTime datetime
) {}
