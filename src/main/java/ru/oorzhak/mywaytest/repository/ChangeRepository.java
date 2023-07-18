package ru.oorzhak.mywaytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.mywaytest.model.Change;

import java.util.Optional;

public interface ChangeRepository extends JpaRepository<Change, Long> {
    Boolean existsByValue(Long value);
    Optional<Change> findByValue(Long value);
}
