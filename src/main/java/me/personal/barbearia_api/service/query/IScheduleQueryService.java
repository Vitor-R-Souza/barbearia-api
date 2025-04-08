package me.personal.barbearia_api.service.query;

import me.personal.barbearia_api.entity.ScheduleEntity;

import java.time.OffsetDateTime;
import java.util.List;

/* Este código define uma interface IScheduleQueryService que declara métodos para realizar operações de consulta e
verificação relacionadas à entidade ScheduleEntity. Essas operações incluem encontrar agendamentos por ID, encontrar
agendamentos dentro de um intervalo de datas e verificar a existência de um agendamento para um determinado intervalo de
tempo. A interface define um contrato que as classes de serviço de consulta devem implementar. */

public interface IScheduleQueryService {

    ScheduleEntity findById(final long id); // busca por id

    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt); // busca naquele mês

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt); // verifica se existe
}
