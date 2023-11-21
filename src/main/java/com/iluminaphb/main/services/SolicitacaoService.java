package com.iluminaphb.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iluminaphb.main.models.Solicitacao;
import com.iluminaphb.main.repositories.SolicitacaoRepository;
import com.iluminaphb.main.services.exceptions.DataBaseException;
import com.iluminaphb.main.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository repository;

    public List<Solicitacao> listarSolicitacoes() {
        return repository.findAll();
    }

    public Solicitacao listarPorId(String id) {
        Optional<Solicitacao> solicitacao = repository.findById(id);
        return solicitacao.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Solicitacao criarSolicitacao(Solicitacao entity) {
        return repository.save(entity);
    }

    public void deletarSolicitacao(String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Solicitacao atualizarSolicitacao(String id, Solicitacao obj) {
        try {
            // Vai buscar pelo ID passado o objeto, pra depois atualizar ele
            Solicitacao newObj = listarPorId(id);
            updateData(obj, newObj);
            return repository.save(newObj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateData(Solicitacao obj, Solicitacao newObj) {
        // Se o objeto que passei no PUT tiver vazio, faz nada
        if (obj.getDescricao() != null) {
            newObj.setDescricao(obj.getDescricao());
        }
        if (obj.getTipoSolicitacao() != null) {
            newObj.setTipoSolicitacao(obj.getTipoSolicitacao());
        }
        if (obj.getEndereco().getNumero() != null &&
                obj.getEndereco().getRua() != null &&
                obj.getEndereco().getBairro() != null) {
            newObj.setEndereco(obj.getEndereco());
        }
    }

}