package me.personal.barbearia_api.repository;

import me.personal.barbearia_api.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* Este código define uma interface IClientRepository que estende JpaRepository. Isso permite que o Spring Data JPA gere
 automaticamente métodos para realizar operações CRUD (Create, Read, Update, Delete) na tabela "CLIENTS" mapeada pela
 entidade ClientEntity. Ele também define métodos personalizados para verificar a existência de clientes por email ou
 telefone e para encontrar clientes por email ou telefone. */

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(final String email); // checa se existe algum registro pelo email
    boolean existsByPhone(final String phone); // checa se existe algum registro pelo telefone

    Optional<ClientEntity> findByEmail(final String email); // procura o registro pelo email
    Optional<ClientEntity> findByPhone(final String phone); // procura o registro pelo telefone


}
