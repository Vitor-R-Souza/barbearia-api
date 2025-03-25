package me.personal.barbearia_api.service.query;

import me.personal.barbearia_api.entity.ClientEntity;

import java.util.List;

public interface IClienteQueryService {

    ClientEntity findByID(final long id);
    List<ClientEntity> list();

    void verifyPhone(final String phone);
    void verifyPhone(final long id,final String phone);

    void verifyEmail(final String email);
    void verifyEmail(final long id,final String email);

}
