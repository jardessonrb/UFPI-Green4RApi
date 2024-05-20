package com.jrblab.green4rapi.service.produtor.impl;

import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Produtor;
import com.jrblab.green4rapi.domain.model.Usuario;
import com.jrblab.green4rapi.domain.repository.ProdutorRepository;
import com.jrblab.green4rapi.domain.repository.UsuarioRepository;
import com.jrblab.green4rapi.service.produtor.ProdutorService;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.handlerexception.exception.EntityNotFoundException;
import com.jrblab.green4rapi.shared.parser.EnderecoParser;
import com.jrblab.green4rapi.shared.parser.ProdutorParser;
import com.jrblab.green4rapi.shared.parser.UsuarioParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutorServiceImpl implements ProdutorService  {

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ProdutorDto criarProdutor(ProdutorForm produtorForm) {
        Optional<Produtor> produtorOptional = produtorRepository.findByCpfEqualsOrUsuarioEmailUsuarioEqualsIgnoreCase(produtorForm.cpf(), produtorForm.usuario().emailUsuario());
        if(produtorOptional.isPresent()){
            throw new EntityAlreadyExistException("Produtor já existente para o CPF");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailUsuarioEqualsIgnoreCase(produtorForm.usuario().emailUsuario());

        if(usuarioOptional.isPresent()){
            throw new EntityAlreadyExistException("Usuário já existente para o Email");
        }

        Usuario usuarioSalvo = salvarUsuario(produtorForm);

        Produtor produtor = ProdutorParser.toModel(produtorForm);

        produtor.setUsuario(usuarioSalvo);

        produtor = produtorRepository.save(produtor);

        return  ProdutorParser.toDto(produtor);
    }

    @Override
    public ProdutorDto buscarPorId(UUID id) {
        Produtor produtor = buscarProdutor(id);

        return ProdutorParser.toDto(produtor);
    }

    public Produtor buscarProdutor(UUID produtorId){
        Produtor produtor = produtorRepository
                .findByUuid(produtorId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Produtor não encontrado para o id "+produtorId)
                );

        return produtor;
    }


    private Usuario salvarUsuario(ProdutorForm produtorForm){
        Endereco endereco = EnderecoParser.toModel(produtorForm.endereco());
        Usuario usuario = UsuarioParser.toModel(produtorForm.usuario());

        usuario.setEndereco(endereco);

        return usuarioRepository.save(usuario);
    }

}
