package com.iluminaphb.main.services;

public class AuthorizationServiceTests {

}

/*
 * package br.com.assocsys;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * import static org.junit.jupiter.api.Assertions.assertNotNull;
 * import static org.junit.jupiter.api.Assertions.assertThrows;
 * import static org.mockito.Mockito.verify;
 * import static org.mockito.Mockito.verifyNoMoreInteractions;
 * import static org.mockito.Mockito.when;
 * 
 * import java.time.Instant;
 * import java.util.Date;
 * import java.util.UUID;
 * 
 * import org.junit.jupiter.api.BeforeEach;
 * import org.junit.jupiter.api.DisplayName;
 * import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith;
 * import org.mockito.InjectMocks;
 * import org.mockito.Mock;
 * import org.mockito.MockitoAnnotations;
 * import org.mockito.junit.jupiter.MockitoExtension;
 * import org.springframework.security.core.userdetails.UserDetails;
 * 
 * import br.com.assocsys.models.Carteira;
 * import br.com.assocsys.models.User;
 * import br.com.assocsys.models.enums.TipoUsuario;
 * import br.com.assocsys.repositories.CarteiraRepository;
 * import br.com.assocsys.repositories.UserRepository;
 * import br.com.assocsys.services.AuthorizationService;
 * import br.com.assocsys.services.exceptions.ServiceException;
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * public class AuthorizationServiceTest {
 * 
 * @Mock
 * UserRepository repository;
 * 
 * @Mock
 * CarteiraRepository carteiraRepository;
 * 
 * @InjectMocks
 * AuthorizationService service;
 * 
 * User user;
 * 
 * // Antes de qualquer coisa vamos iniciar o usuario
 * 
 * @BeforeEach
 * void setup() {
 * MockitoAnnotations.openMocks(this);
 * user = new User(
 * UUID.randomUUID(),
 * "nome 1",
 * "teste@teste.com",
 * "Senha@123",
 * "06465325894",
 * "123456",
 * new Date(0L),
 * Instant.now(),
 * TipoUsuario.USER,
 * new Carteira(
 * 1,
 * new Date(),
 * new Date(),
 * "imagem",
 * Instant.now()));
 * 
 * }
 * 
 * /*
 * TODO:
 * 1 - Validar se já tem email cadastrado [OK]
 * 2 - Validar se já tem CPF cadastrado [OK]
 * 3 - Validar se já tem associação cadastrada [OK]
 * 4 - Validar se já tem matricula cadastrada
 * 5 - Validar se a data de validade é menor que a de expedição
 * 
 * 
 * @Test
 * 
 * @DisplayName("Deve buscar por email, ignorando case sensitive")
 * void deveBuscarUserPorEmailComSucesso() {
 * when(repository.findByEmailIgnoreCase(user.getEmail())).thenReturn(user);
 * 
 * UserDetails result = service.loadUserByUsername(user.getEmail());
 * 
 * // Verificação
 * assertEquals(user, result);
 * // Ver se o repository foi chamado alguma vez
 * verify(repository).findByEmailIgnoreCase(user.getEmail());
 * // Ver se o repository foi chamado mais de uma vez
 * verifyNoMoreInteractions(repository);
 * }
 * 
 * @Test
 * 
 * @DisplayName("Não deve cadastrar usuario com associação já cadastrada")
 * void naoDeveCadastrarAssociacaoJaCadastrada() {
 * when(carteiraRepository.findByAssociacao(user.getCarteira().getAssociacao()))
 * .thenReturn(user.getCarteira());
 * 
 * final ServiceException e = assertThrows(ServiceException.class, () ->
 * service.create(user));
 * 
 * // Ver se a exceção não tá vazia
 * assertNotNull(e);
 * // Ver se a mensagem é a mesma da exceção
 * assertEquals("Já existe um associado com essa associação cadastrada",
 * e.getMessage());
 * }
 * 
 * @Test
 * 
 * @DisplayName("Não deve cadastrar usuario com matricula já cadastrada")
 * void naoDeveCadastrarUserComMatriculaJaCadastrada() {
 * when(repository.findByMatricula(user.getMatricula())).thenReturn(user);
 * 
 * final ServiceException e = assertThrows(ServiceException.class, () ->
 * service.create(user));
 * 
 * // Ver se a exceção não tá vazia
 * assertNotNull(e);
 * // Ver se a mensagem é a mesma da exceção
 * assertEquals("Já existe um associado com essa matricula cadastrada",
 * e.getMessage());
 * }
 * 
 * @Test
 * 
 * @DisplayName("Não deve cadastrar usuario com CPF com menos de 8 e mais de 11 caracteres"
 * )
 * void naoDeveCadastrarUserComCpfInvalido() {
 * user.setCpf("123456");
 * final ServiceException e = assertThrows(ServiceException.class, () ->
 * service.create(user));
 * 
 * // Ver se a variavel e não tá vazia
 * assertNotNull(e);
 * // Ver se a causa não tá vazia
 * // assertNotNull(e.getCause());
 * // Ver se a mensagem é a mesma da exceção
 * assertEquals("CPF deve ter 11 dígitos", e.getMessage());
 * // Verificar se o repositório foi chamado, não deve ser chamado se deu
 * exception
 * // OBS.: Tá quebrando, não sei pq
 * // verifyNoInteractions(repository);
 * 
 * }
 * 
 * @Test
 * 
 * @DisplayName("Deve formatar o CPF corretamente")
 * void deveFormatarCpfCorretamenteSoComNumeros() {
 * // Quando chamar o save do repository vai retornar o user
 * when(repository.save(user)).thenReturn(user);
 * user.setCpf("017.558.430-38");
 * 
 * User result = service.create(user);
 * 
 * assertEquals("01755843038", result.getCpf());
 * }
 * 
 * }
 * 
 */
