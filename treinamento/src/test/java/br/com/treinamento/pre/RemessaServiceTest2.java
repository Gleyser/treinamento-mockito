package br.com.treinamento.pre;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.dao.UsuarioDAO;
import br.com.treinamento.model.Remessa;
import br.com.treinamento.model.Usuario;
import br.com.treinamento.service.NotificadorService;
import br.com.treinamento.service.RemessaService;

public class RemessaServiceTest2 {
	
	@Mock
	private UsuarioDAO usuarioDaoMock;
	
	@Mock
	private RemessaDAO remessaDaoMock;	
	
	@Mock
	private NotificadorService notificadorServiceMock; 
	
	@InjectMocks
	private RemessaService remessaService;
	
	@Captor
	private ArgumentCaptor<Remessa> captorRemessa;
	
	@BeforeEach
	public void beforeEach() {	
		// inicializando os Mocks
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testaIniciaRemessa() {		
		
		// Preciso de um usuario
		Usuario user = new Usuario("teste123", "g@gmail.com", "12345");		
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
		
		// Preciso de um Long
		Mockito.when(remessaDaoMock.adicionarRemessa(Mockito.any(Remessa.class))).thenReturn(new Long(1));
		
		Assert.assertEquals(new Long(1), this.remessaService.iniciaRemessa("g@gmail.com", new BigDecimal("200.00"), "remessa123"));
		
		Mockito.verify(notificadorServiceMock)
		.notificaDonoDaRemessa(Mockito.any(Remessa.class));
		
	}
	
	@Test
	void testaIniciaRemessaComExcecao() {		
		
		// Preciso de um usuario
		Usuario user = new Usuario("teste123", "g@gmail.com", "12345");		
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
		
		// Preciso de um Long
		Mockito.when(remessaDaoMock.adicionarRemessa(Mockito.any(Remessa.class))).thenThrow(RuntimeException.class);
		
		try {
			this.remessaService.iniciaRemessa("g@gmail.com", new BigDecimal("200.00"), "remessa123");			
			Mockito.verifyNoInteractions(notificadorServiceMock);

		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	void testaIniciaRemessaCapturando() {		
		
		// Preciso de um usuario
		Usuario user = new Usuario("teste123", "g@gmail.com", "12345");		
		Mockito.when(usuarioDaoMock.buscarPorEmail(Mockito.anyString())).thenReturn(user);
		
		// Preciso de um Long
		Mockito.when(remessaDaoMock.adicionarRemessa(Mockito.any(Remessa.class))).thenReturn(new Long(1));
		
		Assert.assertEquals(new Long(1), this.remessaService.iniciaRemessa("g@gmail.com", new BigDecimal("200.00"), "remessa123"));
		
		Mockito.verify(remessaDaoMock).adicionarRemessa(captorRemessa.capture());
		
		Remessa remessaCapturada = captorRemessa.getValue();
		
		Assert.assertEquals("remessa123", remessaCapturada.getNome());
		
		
	}
	
	

}
