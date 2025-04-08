package me.personal.barbearia_api.service.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ClientEntity;
import me.personal.barbearia_api.repository.IClientRepository;
import me.personal.barbearia_api.service.IClientService;
import me.personal.barbearia_api.service.query.IClienteQueryService;
import org.springframework.stereotype.Service;

/* Este código define uma classe ClientService que implementa a interface IClientService. Ela utiliza o repositório
IClientRepository para interagir com o banco de dados e o serviço de consulta IClienteQueryService para realizar
verificações antes de salvar ou atualizar clientes. A classe lida com as operações de salvar, atualizar e deletar
clientes, garantindo a integridade dos dados. */

@Service
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ClientService implements IClientService {

    private final IClientRepository repository; // declara o repositorio
    private final IClienteQueryService queryService; // declara o queryService

    @Override // salva
    public ClientEntity save(ClientEntity entity) {
        // checa se o email e telefone já existem
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity); // salva e retorna o resultado
    }

    @Override // atualiza
    public ClientEntity update(ClientEntity entity) {
        // verifica se o email e telefone já esta em uso por outro registro (ignorando o que esta sendo atualizado)
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findByID(entity.getId()); // busca pelo ID e armazena
        // atualiza os dados
        stored.setName(entity.getName());
        stored.setEmail(entity.getEmail());
        stored.setPhone(entity.getPhone());

        return repository.save(stored); // atualiza e retorna o resultado
    }

    @Override // deleta
    public void delete(long id) {
        queryService.findByID(id); // checa se existe
        repository.deleteById(id); // deleta
    }
}
