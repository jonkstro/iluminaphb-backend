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
import com.iluminaphb.main.models.Funcionario;
import com.iluminaphb.main.repositories.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTests {
    @Mock
    private FuncionarioRepository repository;

    @InjectMocks
    private FuncionarioService service;

    private Funcionario funcionario;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        funcionario = new Funcionario(
                UUID.randomUUID().toString(),
                "Funcionario 1",
                "u1106811",
                "86999396565",
                new Endereco(
                        50,
                        "Rua A",
                        "Bairro A",
                        null,
                        null,
                        null),
                null,
                Instant.now());
    }

    @Test
    @DisplayName("Deve listar todos os funcinários")
    void deveListarTodosFuncionarios() {
        when(repository.findAll()).thenReturn(Collections.singletonList(funcionario));
        List<Funcionario> resultado = service.listarFuncionarios();
        // Ver se tão iguais a lista com o resultado retornado da service
        assertEquals(Collections.singletonList(funcionario), resultado);
        //   Ver se foi chamado somente uma ver o repository, se não tá em loop
        verifyNoMoreInteractions(repository);
        //   Ver se o repository foi chamado alguma vez
        verify(repository).findAll();
    }

    @Test
    @DisplayName("Validar a máscara de telefone se está funcionando")
    void deveValidarMascaraDeTelefone() {
        
    }

}