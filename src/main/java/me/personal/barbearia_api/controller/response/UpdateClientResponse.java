package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/* Este código define um record chamado UpdateClientResponse, que é usado para representar os dados de resposta após
atualizar um cliente existente na API. Ele utiliza anotações do Jackson para mapear os nomes das propriedades JSON. */

public record UpdateClientResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("email")
        String email,
        @JsonProperty("phone")
        String phone
) {}