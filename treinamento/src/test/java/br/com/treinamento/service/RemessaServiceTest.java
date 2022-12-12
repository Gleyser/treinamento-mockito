package br.com.treinamento.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.dao.UsuarioDAO;
import br.com.treinamento.model.Usuario;


class RemessaServiceTest {
	
	

	@Test
	void test() {
		UsuarioDAO usuarioDaoMock = Mockito.mock(UsuarioDAO.class);
		RemessaDAO remessaDaoMock = Mockito.mock(RemessaDAO.class);
		NotificadorService notificadorServiceMock = Mockito.mock(NotificadorService.class);
		
		RemessaService remessaService = new RemessaService(usuarioDaoMock, remessaDaoMock, notificadorServiceMock);
		
		Usuario user = new Usuario("amadeu" , "jose@gmail.com", "1234");
		
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
		
		Assert.assertEquals("jose", remessaService.retornaNomeProprietario("jose@gmail.com"));
		
	}

}
