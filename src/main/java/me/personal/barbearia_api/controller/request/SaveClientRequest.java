package me.personal.barbearia_api.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/* Este código define um record chamado SaveClientRequest, que é usado para representar os dados de requisição para salvar
um novo cliente na API. Ele utiliza anotações do Jackson para mapear os nomes das propriedades JSON e anotações do Jakarta
Validation para validar os dados recebidos. */

public record SaveClientRequest(
        @NotNull
        @JsonProperty("name")
        String name,
        @NotNull
        @Email
        @JsonProperty("email")
        String email,
        @NotNull
        @JsonProperty("phone")
        String phone
) {}