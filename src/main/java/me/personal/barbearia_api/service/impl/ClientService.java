package me.personal.barbearia_api.service.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ClientEntity;
import me.personal.barbearia_api.repository.IClientRepository;
import me.personal.barbearia_api.service.IClientService;
import me.personal.barbearia_api.service.query.IClienteQueryService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClienteQueryService queryService;

    @Override
    public ClientEntity save(ClientEntity entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public ClientEntity update(ClientEntity entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findByID(entity.getId());
        stored.setName(entity.getName());
        stored.setEmail(entity.getEmail());
        stored.setPhone(entity.getPhone());

        return repository.save(stored);
    }

    @Override
    public void delete(long id) {
        queryService.findByID(id);
        repository.deleteById(id);
    }
}
