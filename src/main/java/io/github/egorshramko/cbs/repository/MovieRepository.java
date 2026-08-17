package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.egorshramko.cbs.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
