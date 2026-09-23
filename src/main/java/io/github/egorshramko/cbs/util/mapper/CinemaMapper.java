package io.github.egorshramko.cbs.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import io.github.egorshramko.cbs.dto.CinemaDto;
import io.github.egorshramko.cbs.model.Cinema;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CinemaMapper {

    @Mapping(target = "city", expression = "java(cinema.getCity().getName())")
    CinemaDto toDto(Cinema cinema);

    List<CinemaDto> toDtoList(List<Cinema> cinema);

}
