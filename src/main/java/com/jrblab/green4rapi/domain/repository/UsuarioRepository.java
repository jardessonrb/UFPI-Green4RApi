package com.jrblab.green4rapi.domain.repository;

import com.jrblab.green4rapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailUsuarioEqualsIgnoreCase(String emailUsuario);

}
