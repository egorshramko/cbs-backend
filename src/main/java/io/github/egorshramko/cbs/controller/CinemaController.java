package io.github.egorshramko.cbs.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.egorshramko.cbs.dto.CinemaDto;
import io.github.egorshramko.cbs.dto.cinemas.AllCinemasResponse;
import io.github.egorshramko.cbs.service.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j 
@RestController 
@RequiredArgsConstructor 
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/api/v1/cinemas")
    public ResponseEntity<AllCinemasResponse> getMethodName() {
        log.info("Request to /api/v1/cinemas");

        final List<CinemaDto> allCinemas = cinemaService.getAllCinemas();
        final AllCinemasResponse responseBody = new AllCinemasResponse(allCinemas);

        return ResponseEntity.status(200)
            .header("Access-Control-Allow-Origin", "*")
            .body(responseBody);
    }
    

}
