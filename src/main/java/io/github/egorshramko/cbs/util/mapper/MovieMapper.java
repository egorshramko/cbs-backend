package io.github.egorshramko.cbs.util.mapper;

import java.time.Duration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import io.github.egorshramko.cbs.dto.DurationDto;
import io.github.egorshramko.cbs.dto.MovieDto;
import io.github.egorshramko.cbs.model.Movie;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {

    @Mapping(target = "ageLimit", expression = "java(movie.getAgeLimit().getLimit())")
    @Mapping(source = "movie.genres", target = "genre")
    @Mapping(source = "imageUrl", target = "imageUrl")
    MovieDto toDto(Movie movie, String imageUrl);

    default DurationDto map(Duration duration) {
        Long hours = duration.getSeconds() / 60 / 60;
        Long minutes = duration.getSeconds() / 60 % 60;
        return new DurationDto(hours, minutes);
    }
}
