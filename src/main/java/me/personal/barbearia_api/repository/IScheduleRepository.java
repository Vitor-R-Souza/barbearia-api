package me.personal.barbearia_api.repository;

import me.personal.barbearia_api.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

/* Este código define uma interface IScheduleRepository que estende JpaRepository. Isso permite que o Spring Data JPA gere
automaticamente métodos para realizar operações CRUD (Create, Read, Update, Delete) na tabela "SCHEDULES" mapeada pela
entidade ScheduleEntity. Ele também define métodos personalizados para encontrar agendamentos dentro de um intervalo de
datas e para verificar a existência de um agendamento com um determinado intervalo de tempo. */

@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    /* Define um metodo para encontrar agendamentos dentro de um intervalo de datas, ordenados por data e hora de início e
    data e hora de término. */
    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt
    );

    /* Define um metodo para verificar se um agendamento com o intervalo de tempo especificado existe no banco de dados. */
    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
