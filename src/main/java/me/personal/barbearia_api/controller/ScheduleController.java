package me.personal.barbearia_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.personal.barbearia_api.controller.request.SaveScheduleRequest;
import me.personal.barbearia_api.controller.response.SaveScheduleResponse;
import me.personal.barbearia_api.controller.response.ScheduleAppointmentMonthResponse;
import me.personal.barbearia_api.mapper.IScheduleMapper;
import me.personal.barbearia_api.service.IScheduleService;
import me.personal.barbearia_api.service.query.IScheduleQueryService;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/* Este código define um controlador REST (ScheduleController) que lida com requisições relacionadas a agendamentos. Ele
utiliza anotações do Spring Web para mapear as requisições HTTP para os métodos correspondentes. Ele também utiliza Lombok
para gerar automaticamente o construtor com todos os argumentos. */

@RestController
@RequestMapping("schedules") // caminho base
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ScheduleController {

    private final IScheduleService service;
    private final IScheduleQueryService queryService;
    private final IScheduleMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED) // salva
    SaveScheduleResponse save(@RequestBody @Valid final SaveScheduleRequest request){
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT) // deleta
    void delete(@PathVariable final long id){
        service.delete(id);
    }

    @GetMapping("{year}/{month}") // lista pelo mês
    ScheduleAppointmentMonthResponse listMonth(@PathVariable final int year, @PathVariable final int month){
        var yearMonth = YearMonth.of(year, month);
        var startAt = yearMonth.atDay(1)
                .atTime(0,0,0,0)
                .atOffset(UTC);
        var endAt = yearMonth.atEndOfMonth()
                .atTime(23,59,59,999_999_999)
                .atOffset(UTC);
        var entities = queryService.findInMonth(startAt, endAt);
        return mapper.toMonthResponse(year, month, entities);
    }
}
