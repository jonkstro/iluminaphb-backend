package com.iluminaphb.main.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Document(collection = "equipes")
public class Equipe implements Serializable {

    @Id
    private String id;
    @NotNull(message = "Nome da equipe é obrigatória")
    private String nome;
    @NotNull(message = "Placa da viatura é obrigatória")
    private String placaViatura;
    // Ao invés de List, será usado Set, pois não queremos funcionarios repetidos
    private Set<Funcionario> funcionarios = new HashSet<>();
    @CreatedDate
    private Instant createdAt;
    public Equipe() {
    }
    public Equipe(String id, String nome, String placaViatura, Instant createdAt) {
        this.id = id;
        this.nome = nome;
        this.placaViatura = placaViatura;
        this.createdAt = createdAt;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPlacaViatura() {
        return placaViatura;
    }
    public void setPlacaViatura(String placaViatura) {
        this.placaViatura = placaViatura;
    }
    // public Set<Funcionario> getFuncionarios() {
    //     return funcionarios;
    // }
    // public void setFuncionarios(Set<Funcionario> funcionarios) {
    //     this.funcionarios = funcionarios;
    // }
    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    public void removeFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipe other = (Equipe) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
