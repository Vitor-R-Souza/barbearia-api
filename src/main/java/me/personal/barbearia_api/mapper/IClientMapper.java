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

/* Este código define uma interface IClientMapper que usa a biblioteca MapStruct para gerar automaticamente implementações
de métodos de mapeamento entre objetos de diferentes tipos. Isso simplifica a conversão de objetos entre as camadas de
controle e entidade, reduzindo a necessidade de escrever código de mapeamento manual. */

@Mapper(componentModel = SPRING )
public interface IClientMapper {

    @Mapping(target = "id", ignore = true) // ignorar o ID
    @Mapping(target = "schedules", ignore = true) // ignorar o schedules
    ClientEntity toEntity(final SaveClientRequest request); // SaveClientRequest -> ClientEntity

    SaveClientResponse toSaveResponse(ClientEntity entity); // ClientEntity -> SaveClientResponse

    @Mapping(target = "schedules", ignore = true) // ignora o schedules
    ClientEntity toEntity(final long id, UpdateClientRequest request); // UpdateClientRequest -> ClientEntity usando o ID

    UpdateClientResponse toUpdateResponse(final ClientEntity entity); // ClientEntity -> UpdateClientResponse

    ClientDetailResponse toDetailResponse(final ClientEntity entity); // ClientEntity -> ClientDetailResponse

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities); // List<ClientEntity> -> List<ClientEntity>
}
