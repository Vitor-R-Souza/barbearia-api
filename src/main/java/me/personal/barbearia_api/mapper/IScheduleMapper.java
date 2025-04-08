package me.personal.barbearia_api.mapper;

import jakarta.validation.Valid;
import me.personal.barbearia_api.controller.request.SaveScheduleRequest;
import me.personal.barbearia_api.controller.response.ClientScheduleAppointmentResponse;
import me.personal.barbearia_api.controller.response.SaveScheduleResponse;
import me.personal.barbearia_api.controller.response.ScheduleAppointmentMonthResponse;
import me.personal.barbearia_api.entity.ScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

/* Este código define uma interface IScheduleMapper que usa a biblioteca MapStruct para gerar automaticamente implementações
 de métodos de mapeamento entre objetos de diferentes tipos. Isso simplifica a conversão de objetos entre as camadas de
 controle e entidade, reduzindo a necessidade de escrever código de mapeamento manual. */

@Mapper(componentModel = SPRING )
public interface IScheduleMapper {

    @Mapping(target = "id", ignore = true) // ignora o ID
    @Mapping(target = "client.id", source = "clientId")// "clientId" do request mapeada para "client.id" da entidade.
    ScheduleEntity toEntity(@Valid final SaveScheduleRequest request); // SaveScheduleRequest -> ScheduleEntity

    @Mapping(target = "clientId", source = "client.id")// "client.id" do request mapeada para "clientId" da entidade.
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity); // ScheduleEntity -> SaveScheduleResponse

    /* Indica que a propriedade "scheduledAppointments" do response deve ser mapeada
    usando o metodo toClientMonthResponse com a lista de entidades. */
    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(
            final int year,
            final int month,
            final List<ScheduleEntity> entities
    ); // List<ScheduleEntity> -> ScheduleAppointmentMonthResponse

    // List<ScheduleEntity> -> List<ClientScheduleAppointmentResponse>
    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<ScheduleEntity> entities);

    @Mapping(target = "clientId", source = "client.id") // "client.id" do request mapeada para "clientId" da entidade.
    @Mapping(target = "clientName", source = "client.name") // "client.name" do request mapeada para "clientName" da entidade.
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())") // "startAt" do request mapeada para "day" da entidade.
    ClientScheduleAppointmentResponse toClientMonthResponse(final ScheduleEntity entity);
    // ScheduleEntity -> ClientScheduleAppointmentResponse
}
