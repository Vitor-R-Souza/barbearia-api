package me.personal.barbearia_api.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

/* Este código define um record chamado SaveScheduleRequest, que é usado para representar os dados de requisição para salvar
 um novo agendamento na API. Ele utiliza anotações do Jackson para mapear os nomes das propriedades JSON e anotações do
 Jakarta Validation para validar os dados recebidos. */

public record SaveScheduleRequest(
        @NotNull
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @NotNull
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @NotNull
        @JsonProperty("clientId")
        Long clientId
) {}