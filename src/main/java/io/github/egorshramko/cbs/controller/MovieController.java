package io.github.egorshramko.cbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.egorshramko.cbs.dto.MovieDto;
import io.github.egorshramko.cbs.facade.MovieServiceFacade;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceFacade movieServiceFacade;

    @GetMapping
    @ResponseBody
    public List<MovieDto> getAllMovies() {
        return movieServiceFacade.getAllMovies();
    }
    


}
