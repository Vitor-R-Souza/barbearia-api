package me.personal.barbearia_api.service;

import me.personal.barbearia_api.entity.ScheduleEntity;

public interface IScheduleService {
    ScheduleEntity save(final ScheduleEntity entity);
    void delete(final long id);
}
