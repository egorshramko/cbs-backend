package io.github.egorshramko.cbs.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.egorshramko.cbs.dto.sessions.MovieSessionResponse;
import io.github.egorshramko.cbs.model.Session;
import io.github.egorshramko.cbs.repository.SessionRepository;
import io.github.egorshramko.cbs.service.SessionService;
import io.github.egorshramko.cbs.util.mapper.SessionMapper;
import io.github.egorshramko.cbs.util.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service
@RequiredArgsConstructor 
public class SessionServiceImpl implements SessionService {

    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;
    private final Validator<Session> sessionValidator;

    @Override
    public MovieSessionResponse getMovieSessionByDate(Long movieId, LocalDate sessionDate) {
        
        log.info("Retrieving sessions from the database");
 
        List<Session> sessions = sessionRepository.findAllByMovieAndSessionDatetime(movieId, sessionDate)
            .stream()
            .filter(session -> sessionValidator.validate(session)) //Оставляем сеансы, которые еще не начались
            .toList();

        for (Session session : sessions) {
            log.debug("session: {}", session);
        }

        return sessionMapper.toMovieSessionResponse(sessions);
    }

}
