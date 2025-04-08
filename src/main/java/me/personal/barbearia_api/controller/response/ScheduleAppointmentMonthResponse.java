package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/* Este código define um record chamado ScheduleAppointmentMonthResponse, que é usado para representar os dados de resposta
de agendamentos de um determinado mês na API. Ele inclui o ano, o mês e uma lista de agendamentos de clientes. Ele utiliza
anotações do Jackson para mapear os nomes das propriedades JSON. */

public record ScheduleAppointmentMonthResponse(
        @JsonProperty("year")
        int year,
        @JsonProperty("month")
        int month,
        List<ClientScheduleAppointmentResponse> scheduledAppointments
) {}