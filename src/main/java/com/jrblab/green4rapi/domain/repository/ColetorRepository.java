package com.jrblab.green4rapi.domain.repository;

import com.jrblab.green4rapi.domain.model.Coletor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColetorRepository extends JpaRepository<Coletor, Long> {
    Optional<Coletor> findByUuid(UUID id);
    Optional<Coletor> findByCpfCNPJ(String cpfCnpj);
}
