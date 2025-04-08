package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/* Este código define um record chamado SaveScheduleResponse, que é usado para representar os dados de resposta após salvar
um novo agendamento na API. Ele utiliza anotações do Jackson para mapear os nomes das propriedades JSON. */

public record SaveScheduleResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @JsonProperty("clientId")
        Long clientId
) {}