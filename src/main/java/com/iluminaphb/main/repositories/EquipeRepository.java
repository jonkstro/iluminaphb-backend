package com.iluminaphb.main.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iluminaphb.main.models.Equipe;

public interface EquipeRepository extends MongoRepository<Equipe, String>{
    Optional<Equipe> findByNomeIgnoreCase(String nome);
    Optional<Equipe> findByPlacaViaturaIgnoreCase(String placaViatura);
}
