package com.jrblab.green4rapi.controller;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.service.coletor.ColetorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}
