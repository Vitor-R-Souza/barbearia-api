package me.personal.barbearia_api.service;

import me.personal.barbearia_api.entity.ClientEntity;

public interface IClientService {
    ClientEntity save(final ClientEntity entity);
    ClientEntity update(final ClientEntity entity);
    void delete(final long id);

}
