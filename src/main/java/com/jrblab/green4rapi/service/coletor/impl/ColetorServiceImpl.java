package com.jrblab.green4rapi.service.coletor.impl;

import com.jrblab.green4rapi.domain.dto.in.ColetorForm;
import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ColetorDto;
import com.jrblab.green4rapi.domain.model.Coletor;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Usuario;
import com.jrblab.green4rapi.domain.repository.ColetorRepository;
import com.jrblab.green4rapi.domain.repository.UsuarioRepository;
import com.jrblab.green4rapi.service.coletor.ColetorService;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.parser.ColetorParser;
import com.jrblab.green4rapi.shared.parser.EnderecoParser;
import com.jrblab.green4rapi.shared.parser.UsuarioParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColetorServiceImpl implements ColetorService {

    @Autowired
    private ColetorRepository coletorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public ColetorDto criarColetor(ColetorForm coletorForm) {
        Optional<Coletor> coletorOptional = coletorRepository
                .findByCpfCNPJ(coletorForm.cpfCNPJ());

        if(coletorOptional.isPresent()){
            throw new EntityAlreadyExistException("Coletor já existente para o CPF/CNPJ "+coletorForm.cpfCNPJ());
        }

        Optional<Usuario> usuarioOptional = usuarioRepository
                .findByEmailUsuarioEqualsIgnoreCase(coletorForm.usuario().emailUsuario());

        if(usuarioOptional.isPresent()){
            throw new EntityAlreadyExistException("Usuário já existente para o Email "+coletorForm.usuario().emailUsuario());
        }

        Usuario usuario = salvarUsuario(coletorForm);
        Coletor coletor = ColetorParser.toModel(coletorForm);
        coletor.setUsuario(usuario);

        coletor = coletorRepository.save(coletor);

        return ColetorParser.toDto(coletor);
    }

    private Usuario salvarUsuario(ColetorForm coletorForm){
        Endereco endereco = EnderecoParser.toModel(coletorForm.endereco());
        Usuario usuario = UsuarioParser.toModel(coletorForm.usuario());

        usuario.setEndereco(endereco);

        return usuarioRepository.save(usuario);
    }
}
