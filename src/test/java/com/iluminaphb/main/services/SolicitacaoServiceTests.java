package com.iluminaphb.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iluminaphb.main.models.Endereco;
import com.iluminaphb.main.models.Solicitacao;
import com.iluminaphb.main.models.User;
import com.iluminaphb.main.repositories.SolicitacaoRepository;

@ExtendWith(MockitoExtension.class)
public class SolicitacaoServiceTests {
    @Mock
    private SolicitacaoRepository repository;

    @InjectMocks
    private SolicitacaoService service;

    private Solicitacao solicitacao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        solicitacao = new Solicitacao(
                UUID.randomUUID().toString(),
                new User(
                        UUID.randomUUID().toString(),
                        "teste@teste.com",
                        "86999396751",
                        "Senha@123",
                        null,
                        Instant.now()),
                new Endereco(
                        1,
                        "Rua Test",
                        "Bairro Test",
                        null,
                        null,
                        null),
                "Descrição",
                null,
                Instant.now());
    }

    @Test
    @DisplayName("Deve listar todas solicitações")
    void deveListarTodasSolicitacoes() {
        // Transformar um objeto simples em uma collection para entender que é uma lista:
        when(repository.findAll()).thenReturn(Collections.singletonList(solicitacao));
        List<Solicitacao> resultado = service.listarSolicitacoes();

        // Ver se tão iguais a lista com o resultado retornado da service
        assertEquals(Collections.singletonList(solicitacao), resultado);
        // Ver se foi chamado somente uma ver o repository, se não tá em loop
        verifyNoMoreInteractions(repository);
        // Ver se o repository foi chamado alguma vez
        verify(repository).findAll();
    }

}