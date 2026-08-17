package io.github.egorshramko.cbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.egorshramko.cbs.dto.MovieDto;
import io.github.egorshramko.cbs.facade.MovieServiceFacade;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceFacade movieServiceFacade;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        final List<MovieDto> responseBody = movieServiceFacade.getAllMovies();
        return ResponseEntity
                    .status(200)
                    .header("Access-Control-Allow-Origin", "http://localhost:3000")
                    .body(responseBody);
    }
    


}
