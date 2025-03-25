package me.personal.barbearia_api.mapper;

import me.personal.barbearia_api.controller.request.SaveClientRequest;
import me.personal.barbearia_api.controller.request.UpdateClientRequest;
import me.personal.barbearia_api.controller.response.ClientDetailResponse;
import me.personal.barbearia_api.controller.response.ListClientResponse;
import me.personal.barbearia_api.controller.response.SaveClientResponse;
import me.personal.barbearia_api.controller.response.UpdateClientResponse;
import me.personal.barbearia_api.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING )
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);
}
