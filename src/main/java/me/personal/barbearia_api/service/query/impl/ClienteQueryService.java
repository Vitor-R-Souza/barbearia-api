package me.personal.barbearia_api.service.query.impl;

import lombok.AllArgsConstructor;
import me.personal.barbearia_api.entity.ClientEntity;
import me.personal.barbearia_api.exception.EmailInUseException;
import me.personal.barbearia_api.exception.NotFoundException;
import me.personal.barbearia_api.exception.PhoneInUseException;
import me.personal.barbearia_api.repository.IClientRepository;
import me.personal.barbearia_api.service.query.IClienteQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/* Este código define uma classe ClienteQueryService que implementa a interface IClienteQueryService. Ela utiliza o
repositório IClientRepository para interagir com o banco de dados e realizar consultas e verificações relacionadas à
entidade ClientEntity. A classe lida com as operações de encontrar clientes por ID, listar todos os clientes, e verificar a
unicidade de telefone e email. */

@Service
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ClienteQueryService implements IClienteQueryService {

    private final IClientRepository repository;

    @Override // busca pelo ID
    public ClientEntity findByID(long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o cliente de ID: " + id)
        );
    }

    @Override // lista
    public List<ClientEntity> list() {
        return repository.findAll();
    }

    @Override // checa se telefone já existe
    public void verifyPhone(String phone) {
        if (repository.existsByPhone(phone)){
            var message = "O telefone " + phone + " Existe / já esta em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override // checa se o telefone já existe excluindo o usuario atual
    public void verifyPhone(long id, String phone) {
        var optional = repository.findByPhone(phone);
        if (optional.isPresent() &&
                !Objects.equals(
                        optional.get().getPhone(), phone
                )
        ){
            var message = "O telefone " + phone + " Existe / já esta em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override // checa se email já existe
    public void verifyEmail(String email) {
        if (repository.existsByEmail(email)){
            var message = "O email " + email + " Existe / já esta em uso";
            throw new EmailInUseException(message);
        }
    }

    @Override // checa se o email já existe excluindo o usuario atual
    public void verifyEmail(long id, String email) {
        var optional = repository.findByEmail(email);
        if (optional.isPresent() &&
                !Objects.equals(
                        optional.get().getEmail(), email
                )
        ){
            var message = "O email " + email + " Existe / já esta em uso";
            throw new EmailInUseException(message);
        }
    }
}
