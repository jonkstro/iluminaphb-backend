package com.iluminaphb.main.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.iluminaphb.main.models.Solicitacao;

@Repository
public interface SolicitacaoRepository extends MongoRepository<Solicitacao, String> {
    /*
     * Vai permitir buscar a reclamação pelo endereço.rua ignorando case sensitive
     * e buscando por 'contains' onde busca por trecho do nome da rua
     */
    List<Solicitacao> findByEnderecoRuaContainingIgnoreCase(String rua);

    /*
     * Buscar por período de datas
     */
    @Query("{ $and: [ {createdAt: {$gte: ?0}}, {createdAt: {$lte: ?1}}]}")
    List<Solicitacao> fullSearch(Date minDate, Date maxDate);
}