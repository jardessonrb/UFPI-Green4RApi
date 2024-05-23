package com.jrblab.green4rapi.controller;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.in.RecicladorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.domain.dto.out.RecicladorDto;
import com.jrblab.green4rapi.service.coletor.ColetorService;
import com.jrblab.green4rapi.service.reciclador.RecicladorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/reciclador")
public class RecicladorController {

    @Autowired
    private RecicladorService recicladorService;

    @Operation(description = "Criação de Reciclador")
    @PostMapping
    public ResponseEntity<RecicladorDto> cadastrarColetor(@RequestBody @Valid RecicladorForm recicladorForm, UriComponentsBuilder uriComponentsBuilder){
        RecicladorDto recicladorDto = recicladorService.criarReciclador(recicladorForm);

        URI uri = uriComponentsBuilder.path("/produtor/{id}").buildAndExpand(recicladorDto.getId()).toUri();

        return ResponseEntity.created(uri).body(recicladorDto);
    }
    @Operation(description = "Buscar reciclador por Id")
    @GetMapping("/{id}")
    public ResponseEntity<RecicladorDto> buscarRecicladorPorID(@PathVariable("id") UUID recicladorId){
        RecicladorDto recicladorDto = recicladorService.buscarPorId(recicladorId);

        return ResponseEntity.ok(recicladorDto);
    }
}
