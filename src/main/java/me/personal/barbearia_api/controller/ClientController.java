package me.personal.barbearia_api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.personal.barbearia_api.controller.request.SaveClientRequest;
import me.personal.barbearia_api.controller.request.UpdateClientRequest;
import me.personal.barbearia_api.controller.response.ClientDetailResponse;
import me.personal.barbearia_api.controller.response.ListClientResponse;
import me.personal.barbearia_api.controller.response.SaveClientResponse;
import me.personal.barbearia_api.controller.response.UpdateClientResponse;
import me.personal.barbearia_api.mapper.IClientMapper;
import me.personal.barbearia_api.service.IClientService;
import me.personal.barbearia_api.service.query.IClienteQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/* Este código define um controlador REST (ClientController) que lida com requisições relacionadas a clientes. Ele utiliza
anotações do Spring Web para mapear as requisições HTTP para os métodos correspondentes. Ele também utiliza Lombok para
gerar automaticamente o construtor com todos os argumentos. */

@RestController
@RequestMapping("client") // caminho base
@AllArgsConstructor // anotação para gerar o construtor com todos os argumentos
public class ClientController {

    private final IClientService service;
    private final IClienteQueryService queryService;
    private final IClientMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED) // salva
    SaveClientResponse save(@RequestBody @Valid final SaveClientRequest request) {
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }

    @PutMapping("{id}") // atualiza
    UpdateClientResponse update(
            @PathVariable final long id,
            @RequestBody @Valid final UpdateClientRequest request)
    {
        var entity = mapper.toEntity(id, request);
        service.update(entity);
        return mapper.toUpdateResponse(entity);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT) // deleta
    void delete(@PathVariable final long id){
        service.delete(id);
    }


    @GetMapping("{id}") // busca por id
    ClientDetailResponse findById(@PathVariable final long id){
        var entity = queryService.findByID(id);
        return mapper.toDetailResponse(entity);
    }

    @GetMapping // lista todos
    List<ListClientResponse> list(){
        var entities = queryService.list();
        return mapper.toListResponse(entities);
    }


}
