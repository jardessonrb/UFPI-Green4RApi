package com.jrblab.green4rapi.domain.repository;

import com.jrblab.green4rapi.domain.model.Reciclador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecicladorRepository extends JpaRepository<Reciclador, Long> {

    Optional<Reciclador> findByUuid(UUID recicladorId);

    Optional<Reciclador> findByCpfCNPJEqualsIgnoreCase(String cpfCnpj);

}
