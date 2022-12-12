package br.com.treinamento.pre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.dao.UsuarioDAO;
import br.com.treinamento.model.Usuario;
import br.com.treinamento.service.NotificadorService;
import br.com.treinamento.service.RemessaService;

class RemessaServiceTest {
	
	private RemessaService remessaService;

	@Test
	void testaRetornarNomeDoProprietario() {
		
		// Inicializando os Mocks que sao utilizados na classe a ser testada
		UsuarioDAO usuarioDaoMock = Mockito.mock(UsuarioDAO.class);
		
		RemessaDAO remessaDaoMock = Mockito.mock(RemessaDAO.class);
		
		NotificadorService notificadorServiceMock = Mockito.mock(NotificadorService.class);
		
		// Incluindo os Mocks na classe a ser testada
		this.remessaService = new RemessaService(usuarioDaoMock, remessaDaoMock, notificadorServiceMock);
		
		// Definindo o comportamento
		Usuario user = new Usuario("teste123", "g@gmail.com", "12345");
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
		
		Assert.assertEquals("teste123" , this.remessaService.retornaNomeProprietario("g@gmail.com"));
	}

}
