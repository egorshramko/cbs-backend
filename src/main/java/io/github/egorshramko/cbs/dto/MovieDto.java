package io.github.egorshramko.cbs.dto;

import java.util.List;

// Тело ответа на запрос афиши
public record MovieDto(
    Long id,
    String imageUrl,
    String name,
    List<String> genre,
    String country,
    DurationDto duration,
    Integer ageLimit,
    String releaseDate
) {}
