package br.com.treinamento.pre;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.treinamento.dao.HonraDAO;
import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.model.Honra;
import br.com.treinamento.model.Remessa;
import br.com.treinamento.service.HonraService;
import br.com.treinamento.service.NotificadorService;

@ExtendWith(MockitoExtension.class)
class HonraServiceTest {

	@Mock
	private HonraDAO honraDaoMock;
	
	@Mock
	private RemessaDAO remessaDaoMock;
	
	@Mock
	private NotificadorService notificadorServiceMock;
	
	@InjectMocks
	private HonraService honraService;
	
	@Test
	void testaGetStatusDeLiquidacaoDaHonra() {
		
		Remessa remessa = new Remessa();
		remessa.setValor(new BigDecimal("100.00"));
		
		Honra honra = new Honra();
		honra.setValor(new BigDecimal("100.00"));
		honra.setRemessa(remessa);
		
		// Definindo o comportamento
		Mockito.when(honraDaoMock.getHonra(Mockito.anyInt())).thenReturn(honra);
		
		Assert.assertEquals(0 , honraService.getStatusDeLiquidacaoDaHonra(2));
	}

}
