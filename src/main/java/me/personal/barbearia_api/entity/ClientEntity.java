package me.personal.barbearia_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

/* Este código define uma classe ClientEntity que representa um cliente na aplicação. Ele usa anotações JPA para mapear
 a classe para a tabela "CLIENTS" no banco de dados e definir as colunas da tabela. Ele também usa Lombok para gerar
 automaticamente métodos getter, setter e toString. */

@Entity
@Table( // definições da tabela e restrições
        name = "CLIENTS",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
                @UniqueConstraint(name = "UK_PHONE", columnNames = "phone")
        }
)
@Getter
@Setter
@ToString // anotações lmbok para criar getters, setters e toString
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 11)
    private String phone;

    @ToString.Exclude // exlui essa coleção do toString
    @OneToMany(mappedBy = "client", cascade = ALL, orphanRemoval = true) // relação 1 para N com scheduleEntity
    private Set<ScheduleEntity> schedules = new HashSet<>();

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ClientEntity that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone);
    }
}