package com.iluminaphb.main.models;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iluminaphb.main.models.enums.TipoSolicitacao;

import jakarta.persistence.Embedded;
import jakarta.persistence.Id;

@Document(collection = "solicitacoes")
public class Solicitacao implements Serializable {

    @Id
    private String id;
    private User user;
    @Embedded
    private Endereco endereco;
    private String descricao;
    private TipoSolicitacao tipoSolicitacao;
    @CreatedDate
    private Instant createdAt;

    public Solicitacao() {
    }

    public Solicitacao(
            String id,
            User user,
            Endereco endereco,
            String descricao,
            TipoSolicitacao tipoSolicitacao,
            Instant createdAt) {
        this.id = id;
        this.user = user;
        this.endereco = endereco;
        this.descricao = descricao;
        this.tipoSolicitacao = tipoSolicitacao;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
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
        Solicitacao other = (Solicitacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
