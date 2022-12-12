package br.com.treinamento.pre;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.dao.UsuarioDAO;
import br.com.treinamento.model.Usuario;
import br.com.treinamento.service.NotificadorService;
import br.com.treinamento.service.RemessaService;

@ExtendWith(MockitoExtension.class)
public class RemessaServiceTest1 {	
	
	@Mock
	private UsuarioDAO usuarioDaoMock;
	
	@Mock
	private RemessaDAO remessaDaoMock;	
	
	@Mock
	private NotificadorService notificadorServiceMock; 
	
	@InjectMocks
	private RemessaService remessaService;
	
	@Test
	void testaRetornarNomeDoProprietario() {
		
		Usuario user = new Usuario("teste123", "g@gmail.com", "12345");		
		
		// Definindo o comportamento
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
				
		Assert.assertEquals("teste123" , this.remessaService.retornaNomeProprietario("g@gmail.com"));
	}

}
