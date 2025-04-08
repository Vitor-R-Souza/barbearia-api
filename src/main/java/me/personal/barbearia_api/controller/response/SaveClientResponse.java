package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/* Este código define um record chamado SaveClientResponse, que é usado para representar os dados de resposta após salvar um
 novo cliente na API. Ele utiliza anotações do Jackson para mapear os nomes das propriedades JSON. */

public record SaveClientResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("email")
        String email,
        @JsonProperty("phone")
        String phone
) {}