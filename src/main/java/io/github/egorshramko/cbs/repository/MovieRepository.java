package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.egorshramko.cbs.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
