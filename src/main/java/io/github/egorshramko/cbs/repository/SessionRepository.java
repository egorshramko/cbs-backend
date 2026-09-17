package io.github.egorshramko.cbs.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.egorshramko.cbs.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(
        "from Session s " +
        "where movie.id = :movieId " + 
        "and cast(s.sessionDatetime as localdate) = :sessionDate " + 
        "and actual = true")
    List<Session> findAllByMovieAndSessionDatetime(@Param("movieId") Long movieId, @Param("sessionDate") LocalDate date);
}
