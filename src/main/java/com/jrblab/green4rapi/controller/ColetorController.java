package com.jrblab.green4rapi.controller;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.service.coletor.ColetorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/coletor")
public class ColetorController {

    @Autowired
    private ColetorService coletorService;

    @Operation(description = "Criação de Coletor")
    @PostMapping
    public ResponseEntity<ColetorDto> cadastrarColetor(@RequestBody @Valid ColetorForm coletorForm, UriComponentsBuilder uriComponentsBuilder){
        ColetorDto coletorDto = coletorService.criarColetor(coletorForm);

        URI uri = uriComponentsBuilder.path("/produtor/{id}").buildAndExpand(coletorDto.getId()).toUri();

        return ResponseEntity.created(uri).body(coletorDto);
    }
    @Operation(description = "Buscar coletor por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ColetorDto> buscarColetorPorID(@PathVariable("id") UUID coletorId){
        ColetorDto coletorDto = coletorService.buscarPorId(coletorId);

        return ResponseEntity.ok(coletorDto);
    }
}
