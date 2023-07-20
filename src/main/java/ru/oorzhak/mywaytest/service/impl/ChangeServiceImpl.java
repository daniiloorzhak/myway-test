package ru.oorzhak.mywaytest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oorzhak.mywaytest.model.Change;
import ru.oorzhak.mywaytest.repository.ChangeRepository;
import ru.oorzhak.mywaytest.service.ChangeService;

import java.util.Objects;
import java.util.Optional;

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
    public void update(Long value) {
        Optional<Change> lastDbRecord = changeRepository.findTopByOrderByIdDesc();
        if (lastDbRecord.isPresent()
                && Objects.equals(lastDbRecord.get().getValue(), value)) {
            return;
        }
        changeRepository.save(Change.builder().value(value).build());
    }
}
