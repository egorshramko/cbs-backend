package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.egorshramko.cbs.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {

}
