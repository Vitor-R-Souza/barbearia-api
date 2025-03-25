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

@Mapper(componentModel = SPRING )
public interface IScheduleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    ScheduleEntity toEntity(@Valid final SaveScheduleRequest request);

    @Mapping(target = "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity);

    @Mapping(target = "scheduledAppointments", expression = "java(toClientMonthResponse(entities))")
    ScheduleAppointmentMonthResponse toMonthResponse(
            final int year,
            final int month,
            final List<ScheduleEntity> entities
    );

    List<ClientScheduleAppointmentResponse> toClientMonthResponse(final List<ScheduleEntity> entities);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "day", expression = "java(entity.getStartAt().getDayOfMonth())")
    ClientScheduleAppointmentResponse toClientMonthResponse(final ScheduleEntity entity);
}
