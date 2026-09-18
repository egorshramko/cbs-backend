package io.github.egorshramko.cbs.util.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.egorshramko.cbs.dto.SessionDto;
import io.github.egorshramko.cbs.dto.sessions.CinemaFeatures;
import io.github.egorshramko.cbs.dto.sessions.CinemaSessions;
import io.github.egorshramko.cbs.dto.sessions.HallSession;
import io.github.egorshramko.cbs.dto.sessions.MovieSessionResponse;
import io.github.egorshramko.cbs.model.Cinema;
import io.github.egorshramko.cbs.model.Hall;
import io.github.egorshramko.cbs.model.Session;
import io.github.egorshramko.cbs.model.enums.MovieFormat;
import io.github.egorshramko.cbs.service.S3PresignedUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Component
@RequiredArgsConstructor 
public class SessionMapper {

    private final S3PresignedUrlService s3PresignedUrlService;

    public MovieSessionResponse toMovieSessionResponse(List<Session> sessions) {

        log.info("Sessions mapping");

        Set<Cinema> uniqueCinemas = sessions.stream()
                .map(session -> session.getHall().getCinema())
                .collect(Collectors.toSet());

        log.debug("uniqueCinemas: {}", uniqueCinemas);

        List<CinemaSessions> cinemaDtos = new ArrayList<>();
        for (Cinema cinema : uniqueCinemas) {

            List<HallSession> hallSessions = new ArrayList<>();
            Set<Hall> uniqueCinemaHalls = sessions.stream()
                    .map(session -> session.getHall())
                    .filter(hall -> hall.getCinema().equals(cinema))
                    .collect(Collectors.toSet());

            for (Hall hall : uniqueCinemaHalls) {

                HallSession hallSession = new HallSession(
                    hall.getName(),
                    hall.getMovieFormats().stream()
                            .map(movieFormat -> movieFormat.getFormat().toLowerCase())
                            .toList(),
                    sessions.stream()
                            .filter(session -> session.getHall().equals(hall))
                            .map(session -> mapSessionToDto(session))
                            .toList()
                );

                hallSessions.add(hallSession);

            }


            Boolean imaxAvailable = cinema.getHalls().stream()
                    .flatMap(hall -> hall.getMovieFormats().stream())
                    .collect(Collectors.toSet())
                    .contains(MovieFormat.IMAX);

            CinemaSessions currentCinemaSessions = new CinemaSessions(
                cinema.getId(),
                cinema.getName(),
                s3PresignedUrlService.getPresignedUrl("cinemas", cinema.getPhotoFilename()),
                cinema.getCity().getName(),
                cinema.getAddress(),
                new CinemaFeatures(cinema.getHalls().size(), imaxAvailable, cinema.getHasParking()),
                hallSessions
            );

            cinemaDtos.add(currentCinemaSessions);
        }

        return new MovieSessionResponse(cinemaDtos);
    } 

    private SessionDto mapSessionToDto(Session session) {
        return new SessionDto(
            session.getId(),
            session.getSessionDatetime()
        );
    }

}
