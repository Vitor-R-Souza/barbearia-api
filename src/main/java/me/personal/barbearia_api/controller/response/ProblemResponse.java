package me.personal.barbearia_api.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.OffsetDateTime;

/* Este código define um record chamado ProblemResponse, que é usado para representar uma resposta de problema (erro) na
API. Ele inclui informações sobre o status do erro, o timestamp em que ocorreu e uma mensagem descritiva. Ele utiliza
anotações do Jackson para mapear os nomes das propriedades JSON e anotações do Lombok para gerar um builder. */

public record ProblemResponse(
        @JsonProperty("status")
        Integer status,
        @JsonProperty("timestamp")
        OffsetDateTime timestamp,
        @JsonProperty("message")
        String message)
{

    @Builder(toBuilder = true)
    public ProblemResponse{}

}