package ru.oorzhak.mywaytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.oorzhak.mywaytest.model.Change;

public interface ChangeRepository extends JpaRepository<Change, Long> {
}
