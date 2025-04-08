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

/* Este código define uma classe ScheduleQueryService que implementa a interface IScheduleQueryService. Ela utiliza o
repositório IScheduleRepository para interagir com o banco de dados e realizar consultas e verificações relacionadas à
entidade ScheduleEntity. A classe lida com as operações de encontrar agendamentos por ID, encontrar agendamentos em um mês
específico e verificar a existência de agendamentos para um determinado intervalo de tempo. */

@Service
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ScheduleQueryService implements IScheduleQueryService {

    private final IScheduleRepository repository;

    @Override // busca pelo ID
    public ScheduleEntity findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agenda não encontrada")
        );
    }

    @Override // busca em um mês especifico
    public List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override // checa se já existe
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "já existe um cliente agendado nesse horário";
            throw new ScheduleInUseException(message);
        }
    }
}
