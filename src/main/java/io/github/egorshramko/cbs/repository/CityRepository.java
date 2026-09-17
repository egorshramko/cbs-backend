package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.egorshramko.cbs.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
