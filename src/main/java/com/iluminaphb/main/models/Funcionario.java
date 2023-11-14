package com.iluminaphb.main.models;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Document(collection = "funcionarios")
public class Funcionario implements Serializable {

    @Id
    private String id;
    @NotNull(message = "Nome do funcionário é obrigatório")
    private String nome;
    @NotNull(message = "Matrícula do funcionário é obrigatório")
    private String matricula;
    @NotNull(message = "Telefone do funcionário é obrigatório")
    private String telefone;
    @NotNull
    private Endereco endereco;
    @NotNull(message = "Função do funcionário é obrigatória")
    private String funcao;
    @CreatedDate
    private Instant createdAt;

    public Funcionario() {
    }

    public Funcionario(
            String id,
            String nome,
            String matricula,
            String telefone,
            Endereco endereco,
            String funcao,
            Instant createdAt) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.endereco = endereco;
        this.funcao = funcao;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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
        Funcionario other = (Funcionario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
