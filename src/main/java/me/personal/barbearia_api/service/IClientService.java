package me.personal.barbearia_api.service;

import me.personal.barbearia_api.entity.ClientEntity;

/* Este código define uma interface IClientService que declara métodos para realizar operações de serviço relacionadas à
entidade ClientEntity. Essas operações incluem salvar, atualizar e deletar clientes. A interface define um contrato que as
classes de serviço devem implementar. */

public interface IClientService {
    ClientEntity save(final ClientEntity entity); // salvar cliente
    ClientEntity update(final ClientEntity entity); // update cliente
    void delete(final long id); // delete cliente

}
