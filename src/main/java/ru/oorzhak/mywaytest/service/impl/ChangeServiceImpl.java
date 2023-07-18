package ru.oorzhak.mywaytest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oorzhak.mywaytest.model.Change;
import ru.oorzhak.mywaytest.repository.ChangeRepository;
import ru.oorzhak.mywaytest.service.ChangeService;

@Service
@AllArgsConstructor
public class ChangeServiceImpl implements ChangeService {
    private final ChangeRepository changeRepository;

    @Override
    public Long increment(Long value) {
        return changeRepository.save(Change.builder().value(value + 1).build()).getValue();
    }

    @Override
    public Long decrement(Long value) {
        return changeRepository.save(Change.builder().value(value - 1).build()).getValue();
    }

    @Override
    public Long update(Long value) {
        return changeRepository.save(Change.builder().value(value).build()).getValue();
    }
}
