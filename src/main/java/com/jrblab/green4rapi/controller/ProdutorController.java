package com.jrblab.green4rapi.controller;

import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.service.produtor.ProdutorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    @Autowired
    private ProdutorService produtorService;

    @Operation(description = "Criação de produtor")
    @PostMapping
    public ResponseEntity<ProdutorDto> cadastrarProdutor(@RequestBody @Valid ProdutorForm produtorForm, UriComponentsBuilder uriComponentsBuilder){
        ProdutorDto produtorDto = produtorService.criarProdutor(produtorForm);

        URI uri = uriComponentsBuilder.path("/produtor/{id}").buildAndExpand(produtorDto.getId()).toUri();

        return ResponseEntity.created(uri).body(produtorDto);
    }

    @Operation(description = "Buscar produtor por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutorDto> cadastrarProdutor(@PathVariable("id") UUID produtorId){
        ProdutorDto produtorDto = produtorService.buscarPorId(produtorId);

        return ResponseEntity.ok(produtorDto);
    }
}
