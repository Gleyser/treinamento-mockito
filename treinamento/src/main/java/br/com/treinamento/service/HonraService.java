package br.com.treinamento.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.dao.HonraDAO;
import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.model.Honra;
import br.com.treinamento.model.Remessa;

@Service
public class HonraService {

	@Autowired
	private HonraDAO honraDao;

	@Autowired
	private RemessaDAO remessaDao;
	
	@Autowired
	private NotificadorService notificadorService;

	public void cadastraHonra(BigDecimal valor, String sigla, int idRemessa) {

		Remessa remessa = this.remessaDao.getRemessa(idRemessa);

		Honra honra = new Honra();
		honra.setValor(valor);
		honra.setSigla(sigla);
		honra.setRemessa(remessa);
		honra.setData(LocalDate.now());

		this.honraDao.adicionarHonra(honra);

	}

	public int getStatusDeLiquidacaoDaHonra(int idHonra) {

		Honra honra = this.honraDao.getHonra(idHonra);
		return honra.statusDeLiquidacao();

	}

	public void enviaBalancoDaHonraParaProprietario(int idHonra) {		
		Honra honra = this.honraDao.getHonra(idHonra);
		this.notificadorService.enviaBalancoDeHonra(honra);		

	}
	
	public void notificaPeloStatusDeLiquidacaoDaHonra(int idHonra) {

		// olha o numero magico aqui
		if (getStatusDeLiquidacaoDaHonra(idHonra) == 0) {
			enviaBalancoDaHonraParaProprietario(idHonra);
		}

	}


}
