package me.personal.barbearia_api.service.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ScheduleEntity;
import me.personal.barbearia_api.repository.IScheduleRepository;
import me.personal.barbearia_api.service.IScheduleService;
import me.personal.barbearia_api.service.query.IScheduleQueryService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
