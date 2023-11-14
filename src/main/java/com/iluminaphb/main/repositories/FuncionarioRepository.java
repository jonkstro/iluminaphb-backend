package com.iluminaphb.main.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.iluminaphb.main.models.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
    Optional<Funcionario> findByMatriculaIgnoreCase(String matricula);
}
