package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.egorshramko.cbs.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long>  {

}
