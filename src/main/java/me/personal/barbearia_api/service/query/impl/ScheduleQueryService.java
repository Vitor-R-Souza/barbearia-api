package me.personal.barbearia_api.service.query.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ScheduleEntity;
import me.personal.barbearia_api.exception.NotFoundException;
import me.personal.barbearia_api.exception.ScheduleInUseException;
import me.personal.barbearia_api.repository.IScheduleRepository;

import me.personal.barbearia_api.service.query.IScheduleQueryService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService {

    private final IScheduleRepository repository;

    @Override
    public ScheduleEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agenda não encontrada")
        );
    }

    @Override
    public List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "já existe um cliente agendado nesse horário";
            throw new ScheduleInUseException(message);
        }
    }
}
