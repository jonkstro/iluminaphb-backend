package com.iluminaphb.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iluminaphb.main.models.Equipe;
import com.iluminaphb.main.repositories.EquipeRepository;
import com.iluminaphb.main.services.exceptions.DataBaseException;
import com.iluminaphb.main.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepository repository;

    public List<Equipe> listarEquipes() {
        return repository.findAll();
    }

    public Equipe listarPorId(String id) {
        Optional<Equipe> equipe = repository.findById(id);
        return equipe.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Equipe listarPorNome(String nome) {
        Optional<Equipe> equipe = repository.findByNomeIgnoreCase(nome);
        return equipe.orElseThrow(() -> new ResourceNotFoundException(nome));
    }

    public Equipe listarPorViatura(String viatura) {
        Optional<Equipe> equipe = repository.findByPlacaViaturaIgnoreCase(viatura);
        return equipe.orElseThrow(() -> new ResourceNotFoundException(viatura));
    }

    public Equipe criarEquipe(Equipe obj) {
        return repository.save(obj);
    }

    public void deletarEquipe(String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            // Se tentar apagar sem mandar ID
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            // Se não achar o ID que tentou apagar
            throw new DataBaseException(e.getMessage());
        }
    }

    public Equipe atualizarEquipe(String id, Equipe obj) {
        try {
            // Vai buscar pelo ID, se não achar nada já mete a exceção
            Equipe newObj = listarPorId(id);
            updateData(obj, newObj);
            return repository.save(newObj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateData(Equipe obj, Equipe newObj) {
        if (obj.getNome() != null) {
            newObj.setNome(obj.getNome());
        }
        if (obj.getPlacaViatura() != null) {
            newObj.setPlacaViatura(obj.getPlacaViatura());
        }
        if (obj.getFuncionarios() != null) {
            newObj.setFuncionarios(obj.getFuncionarios());
        }
    }
}
