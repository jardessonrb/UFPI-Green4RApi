package com.jrblab.green4rapi.service.produtor.impl;

import com.jrblab.green4rapi.domain.dto.in.EnderecoForm;
import com.jrblab.green4rapi.domain.dto.in.ProdutorForm;
import com.jrblab.green4rapi.domain.dto.in.UsuarioForm;
import com.jrblab.green4rapi.domain.dto.out.ProdutorDto;
import com.jrblab.green4rapi.domain.enums.TipoUsuario;
import com.jrblab.green4rapi.domain.model.Endereco;
import com.jrblab.green4rapi.domain.model.Produtor;
import com.jrblab.green4rapi.domain.model.Usuario;
import com.jrblab.green4rapi.domain.repository.ProdutorRepository;
import com.jrblab.green4rapi.domain.repository.UsuarioRepository;
import com.jrblab.green4rapi.service.produtor.ProdutorService;
import com.jrblab.green4rapi.shared.handlerexception.exception.dto.EntityAlreadyExistException;
import com.jrblab.green4rapi.shared.parsers.EnderecoParser;
import com.jrblab.green4rapi.shared.parsers.ProdutorParser;
import com.jrblab.green4rapi.shared.parsers.UsuarioParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    private Usuario salvarUsuario(ProdutorForm produtorForm){
        Endereco endereco = EnderecoParser.toModel(produtorForm.endereco());
        Usuario usuario = UsuarioParser.toModel(produtorForm.usuario());

        usuario.setEndereco(endereco);

        return usuarioRepository.save(usuario);
    }

}
