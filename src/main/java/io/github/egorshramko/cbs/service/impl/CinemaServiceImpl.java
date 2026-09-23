package io.github.egorshramko.cbs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.egorshramko.cbs.dto.CinemaDto;
import io.github.egorshramko.cbs.model.Cinema;
import io.github.egorshramko.cbs.repository.CinemaRepository;
import io.github.egorshramko.cbs.service.CinemaService;
import io.github.egorshramko.cbs.util.mapper.CinemaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service
@RequiredArgsConstructor 
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;

    @Override
    public List<CinemaDto> getAllCinemas() {

        log.info("Retrieving all cinemas from the database");

        final List<Cinema> allCinemas = cinemaRepository.findAll();

        return cinemaMapper.toDtoList(allCinemas);
    }

}
