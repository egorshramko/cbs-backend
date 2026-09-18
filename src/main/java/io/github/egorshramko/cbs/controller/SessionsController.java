package io.github.egorshramko.cbs.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.egorshramko.cbs.dto.sessions.MovieSessionResponse;
import io.github.egorshramko.cbs.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j 
@RestController 
@RequiredArgsConstructor 
public class SessionsController {

    private final SessionService sessionService;

    @GetMapping("/api/v1/sessions")
    public ResponseEntity<MovieSessionResponse> getMovieSessionsByDate(
        @RequestParam String movie,
        @RequestParam LocalDate date
    ) {

        log.info("Calling /api/v1/sessions?movie={}&date={}", movie, date.toString());

        MovieSessionResponse responseBody = sessionService.getMovieSessionByDate(Long.parseLong(movie), date);
        return ResponseEntity
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .body(responseBody);

    }
    

}
