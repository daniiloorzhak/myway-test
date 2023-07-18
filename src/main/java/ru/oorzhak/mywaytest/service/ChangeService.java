package ru.oorzhak.mywaytest.service;

public interface ChangeService {
    Long increment(Long value);
    Long decrement(Long value);
    Long update(Long value);
}
