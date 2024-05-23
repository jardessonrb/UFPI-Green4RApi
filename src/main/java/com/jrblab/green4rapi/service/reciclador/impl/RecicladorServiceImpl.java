package com.jrblab.green4rapi.service.reciclador.impl;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.in.RecicladorForm;
import com.jrblab.green4rapi.domain.dto.out.RecicladorDto;
import com.jrblab.green4rapi.domain.enums.TipoUsuario;
import com.jrblab.green4rapi.domain.model.Coletor;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Reciclador;
import com.jrblab.green4rapi.domain.model.Usuario;
import com.jrblab.green4rapi.domain.repository.RecicladorRepository;
import com.jrblab.green4rapi.domain.repository.UsuarioRepository;
import com.jrblab.green4rapi.service.reciclador.RecicladorService;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityNotFoundException;
import com.jrblab.green4rapi.shared.parser.ColetorParser;
import com.jrblab.green4rapi.shared.parser.EnderecoParser;
import com.jrblab.green4rapi.shared.parser.RecicladorParser;
import com.jrblab.green4rapi.shared.parser.UsuarioParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RecicladorServiceImpl implements RecicladorService {

    @Autowired
    private RecicladorRepository recicladorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public RecicladorDto criarReciclador(RecicladorForm recicladorForm) {
        Optional<Reciclador> recicladorOptional = recicladorRepository
                .findByCpfCNPJEqualsIgnoreCase(recicladorForm.cpfCNPJ());

        if(recicladorOptional.isPresent()){
            throw new EntityAlreadyExistException("Reciclador já existente para o CPF/CNPJ "+recicladorForm.cpfCNPJ());
        }

        Optional<Usuario> usuarioOptional = usuarioRepository
                .findByEmailUsuarioEqualsIgnoreCase(recicladorForm.usuario().emailUsuario());

        if(usuarioOptional.isPresent()){
            throw new EntityAlreadyExistException("Usuário já existente para o Email "+recicladorForm.usuario().emailUsuario());
        }

        Usuario usuario = salvarUsuario(recicladorForm);
        Reciclador reciclador = RecicladorParser.toModel(recicladorForm);
        reciclador.setUsuario(usuario);

        reciclador = recicladorRepository.save(reciclador);

        return RecicladorParser.toDto(reciclador);
    }

    @Override
    public RecicladorDto buscarPorId(UUID recicladorId) {
        Reciclador reciclador = recicladorRepository
                .findByUuid(recicladorId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Reciclador não encontrado para o id "+recicladorId)
                );

        return RecicladorParser.toDto(reciclador);
    }

    private Usuario salvarUsuario(RecicladorForm recicladorForm){
        Endereco endereco = EnderecoParser.toModel(recicladorForm.endereco());
        Usuario usuario = UsuarioParser.toModel(recicladorForm.usuario());
        usuario.setTipoUsuario(TipoUsuario.RECLICADOR);
        usuario.setEndereco(endereco);

        return usuarioRepository.save(usuario);
    }
}
