package me.personal.barbearia_api.service.query;

import me.personal.barbearia_api.entity.ClientEntity;

import java.util.List;

/* Este código define uma interface IClienteQueryService que declara métodos para realizar operações de consulta e
verificação relacionadas à entidade ClientEntity. Essas operações incluem encontrar clientes por ID, listar todos os
clientes, e verificar a unicidade de telefone e email. A interface define um contrato que as classes de serviço de consulta
devem implementar. */

public interface IClienteQueryService {

    ClientEntity findByID(final long id); // busca por id
    List<ClientEntity> list(); // lista

    void verifyPhone(final String phone); // verifica telefone
    void verifyPhone(final long id,final String phone); // ^^ com ID

    void verifyEmail(final String email); // verifica email
    void verifyEmail(final long id,final String email); // ^^ com ID

}
