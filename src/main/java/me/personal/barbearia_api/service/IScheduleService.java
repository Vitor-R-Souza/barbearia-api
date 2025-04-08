package me.personal.barbearia_api.service;

import me.personal.barbearia_api.entity.ScheduleEntity;

/* Este código define uma interface IScheduleService que declara métodos para realizar operações de serviço relacionadas à
entidade ScheduleEntity. Essas operações incluem salvar e deletar agendamentos. A interface define um contrato que as
classes de serviço devem implementar. */

public interface IScheduleService {
    ScheduleEntity save(final ScheduleEntity entity); // salvar schedule
    void delete(final long id); // deletar schedule
}
