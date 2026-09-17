package io.github.egorshramko.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.egorshramko.cbs.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
