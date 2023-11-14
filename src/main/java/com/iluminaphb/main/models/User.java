package com.iluminaphb.main.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.iluminaphb.main.models.enums.TipoUsuario;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;
    @Email(message = "Email inválido")
    @NotNull(message = "Email é obrigatório")
    private String email;
    @NotNull(message = "Telefone é obrigatório")
    private String telefone;
    @NotNull(message = "Senha é obrigatória")
    private String password;
    private TipoUsuario tipoUsuario;
    // Ao invés de List, será usado Set, pois não queremos solicitações repetidas
    private Set<Solicitacao> solicitacoes = new HashSet<>();
    @CreatedDate
    private Instant createdAt;

    public User() {
    }

    public User(
            String id,
            String email,
            String telefone,
            String password,
            TipoUsuario tipoUsuario,
            Instant createdAt) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario.getTipo();
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Set<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    // public void setSolicitacoes(List<Solicitacao> solicitacoes) {
    // this.solicitacoes = solicitacoes;
    // }
    public void addSolicitacao(Solicitacao solicitacao) {
        solicitacoes.add(solicitacao);
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
