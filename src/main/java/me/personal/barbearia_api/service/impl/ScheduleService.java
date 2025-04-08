package me.personal.barbearia_api.service.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ScheduleEntity;
import me.personal.barbearia_api.repository.IScheduleRepository;
import me.personal.barbearia_api.service.IScheduleService;
import me.personal.barbearia_api.service.query.IScheduleQueryService;
import org.springframework.stereotype.Service;

/* Este código define uma classe ScheduleService que implementa a interface IScheduleService. Ela utiliza o repositório
IScheduleRepository para interagir com o banco de dados e o serviço de consulta IScheduleQueryService para realizar
verificações antes de salvar agendamentos. A classe lida com as operações de salvar e deletar agendamentos, garantindo a
integridade dos dados. */

@Service
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override // salva
    public ScheduleEntity save(ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt()); // verifica se já existe
        return repository.save(entity); // salva e retorna  resultado
    }

    @Override // deleta
    public void delete(long id) {
        queryService.findById(id); // verifica se existe
        repository.deleteById(id); // deleta
    }
}
