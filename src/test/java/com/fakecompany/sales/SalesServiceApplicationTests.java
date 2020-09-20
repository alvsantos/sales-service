package com.fakecompany.sales;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.entity.Endereco;
import com.fakecompany.sales.repository.ClientesRepository;
import com.fakecompany.sales.service.ClientesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SalesServiceApplicationTests {

	private ClientesService clientesService;

	private ClientesRepository clientesRepository;

	public SalesServiceApplicationTests() {
		this.clientesService = new ClientesService();
		this.clientesRepository = Mockito.mock(ClientesRepository.class);

		ReflectionTestUtils.setField(clientesService, "clientesRepository", clientesRepository);
	}

	@Test
	void testInclusaoClienteMaior18Anos() throws Exception {

		String id = "1498742189721478921897";

		Cliente input = Cliente.builder()
				.nome("Arthur")
				.dataNascimento(LocalDate.now().minusYears(18).minusDays(1))
				.enderecos(Collections.singletonList(Endereco.builder()
						.rua("Dona Madalena")
						.numero("100")
						.bairro("Restinga")
						.cidade("Porto Alegre")
						.cep("91790010")
						.estado("RS")
						.pais("Brasil")
					.build()))
				.build();

		Cliente output = Cliente.builder()
				.id(id)
				.nome("Arthur")
				.dataNascimento(LocalDate.now().minusYears(18).minusDays(1))
				.build();

		Mockito.when(this.clientesRepository.save(Mockito.any())).thenReturn(output);

		Cliente resultado = clientesService.inserir(input);

		assertEquals("ID precisa ter sido retornado", id, resultado.getId());

	}

	@Test
	void testInclusaoClienteMenor18Anos() throws Exception {

		Cliente input = Cliente.builder()
				.nome("Arthur")
				.dataNascimento(LocalDate.now().minusYears(17))
				.build();

		Exception exception = assertThrows(Exception.class, () -> {
			clientesService.inserir(input);
		});

		assertTrue(exception.getMessage().contains("Cliente menor de 18 anos."));

	}

}
