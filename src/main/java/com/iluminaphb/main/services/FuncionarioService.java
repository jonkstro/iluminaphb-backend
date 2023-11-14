package com.iluminaphb.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iluminaphb.main.models.Funcionario;
import com.iluminaphb.main.repositories.FuncionarioRepository;
import com.iluminaphb.main.services.exceptions.DataBaseException;
import com.iluminaphb.main.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarFuncionarios() {
        return repository.findAll();
    }

    public Funcionario listarPorId(String id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        return funcionario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionario listarPorMatricula(String matricula) {
        Optional<Funcionario> funcionario = repository.findByMatriculaIgnoreCase(matricula);
        return funcionario.orElseThrow(() -> new ResourceNotFoundException(matricula));
    }

    public Funcionario criarFuncionario(Funcionario entity) {
        validaDados(entity);
        return repository.save(entity);
    }

    public void deletarFuncionario(String id) {
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

    public Funcionario atualFuncionario(String id, Funcionario obj) {
        try {
            // Vai buscar pelo ID, se não achar nada já mete a exceção
            Funcionario newObj = listarPorId(id);
            updateData(obj, newObj);
            return repository.save(newObj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    // Validar os dados do objeto antes de salvar
    private void validaDados(Funcionario entity) {
        if (entity.getTelefone() != null) {
            String telefone = entity.getTelefone();
            // Remover caracteres não numéricos
            String numeros = telefone.replaceAll("\\D", "");
            // Verificar se há pelo menos 10 dígitos no número
            if (numeros.length() < 11) {
                throw new DataBaseException("Número de telefone inválido");
            } else {
                // Adicionar a máscara
                String formato = "(%s%s)%s%s%s%s-%s%s%s%s";
                String numeroFormatado = String.format(formato, numeros.substring(numeros.length() - 11).split(""));
                entity.setTelefone(numeroFormatado);
            }
        } else {
            throw new DataBaseException("Telefone é obrigatório");
        }
    }

    private void updateData(Funcionario obj, Funcionario newObj) {
        if (obj.getNome() != null) {
            newObj.setNome(obj.getNome());
        }
        if (obj.getFuncao() != null) {
            newObj.setFuncao(obj.getFuncao());
        }
        if (obj.getTelefone() != null) {
            newObj.setTelefone(obj.getTelefone());
        }
        if (obj.getFuncao() != null) {
            newObj.setFuncao(obj.getFuncao());
        }
        if (obj.getEndereco().getNumero() != null &&
                obj.getEndereco().getRua() != null &&
                obj.getEndereco().getBairro() != null) {
            newObj.setEndereco(obj.getEndereco());
        }
    }

}
