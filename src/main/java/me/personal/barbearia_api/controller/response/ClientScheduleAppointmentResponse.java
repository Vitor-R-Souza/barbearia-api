package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/* Este código define um record chamado ClientScheduleAppointmentResponse, que é usado para representar os dados de resposta
 de um agendamento de cliente na API. Ele inclui informações sobre o agendamento e o cliente associado. Ele utiliza
  anotações do Jackson para mapear os nomes das propriedades JSON. */

public record ClientScheduleAppointmentResponse(
        @JsonProperty("id")
        Long id,
        @JsonProperty("day")
        Integer day,
        @JsonProperty("startAt")
        OffsetDateTime startAt,
        @JsonProperty("endAt")
        OffsetDateTime endAt,
        @JsonProperty("clientId")
        Long clientId,
        @JsonProperty("clientName")
        String clientName
) {}