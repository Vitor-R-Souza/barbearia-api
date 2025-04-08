package me.personal.barbearia_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

/* Este código define uma classe ScheduleEntity que representa um agendamento na aplicação. Ele usa anotações JPA para
 mapear a classe para a tabela "SCHEDULES" no banco de dados e definir as colunas da tabela. Ele também usa Lombok para
 gerar automaticamente métodos getter, setter e toString. */

@Entity
@Table( // definições da tabela e restrições
        name = "SCHEDULES",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_SCHEDULE_INTERVAL", columnNames = {"start_at", "end_at"}),
        }
)
@Getter
@Setter
@ToString // anotações lmbok para criar getters, setters e toString
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, name = "start_at")
    private OffsetDateTime startAt;

    @Column(nullable = false, name = "end_at")
    private OffsetDateTime endAt;

    @ToString.Exclude // exlui essa coleção do toString
    @ManyToOne
    @JoinColumn(name = "client_id") // relação N para 1 com clientEntity
    private ClientEntity client = new ClientEntity();

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ScheduleEntity that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(startAt, that.startAt) &&
                Objects.equals(endAt, that.endAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startAt, endAt);
    }
}