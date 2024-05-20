package com.jrblab.green4rapi.domain.repository;

import com.jrblab.green4rapi.domain.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {

    Optional<Produtor> findByCpfEqualsOrUsuarioEmailUsuarioEqualsIgnoreCase(String cpf, String email);

    Optional<Produtor> findByUuid(UUID id);
}
