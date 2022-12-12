package br.com.treinamento.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.dao.RemessaDAO;
import br.com.treinamento.dao.UsuarioDAO;
import br.com.treinamento.model.Remessa;
import br.com.treinamento.model.Usuario;

@Service
public class RemessaService {

	private UsuarioDAO usuarioDao;
	private RemessaDAO remessaDao;
	private NotificadorService notificadorService;

	@Autowired
	public RemessaService(UsuarioDAO usuarioDao, RemessaDAO remessaDao, NotificadorService notificadorService) {
		this.usuarioDao = usuarioDao;
		this.remessaDao = remessaDao;
		this.notificadorService = notificadorService;
	}

	public String retornaNomeProprietario(String emailDoProprietario) {
		return this.usuarioDao.buscarPorEmail(emailDoProprietario).getNome();
	}

	public Long iniciaRemessa(String emailDoProprietario, BigDecimal valor, String nome) {

		Usuario proprietario = this.usuarioDao.buscarPorEmail(emailDoProprietario);

		Remessa remessa = new Remessa();
		remessa.setNome(nome);
		remessa.setValor(valor);
		remessa.setDataAbertura(LocalDate.now());
		remessa.setUsuario(proprietario);

		Long id = this.remessaDao.adicionarRemessa(remessa);

		this.notificadorService.notificaDonoDaRemessa(remessa);

		return id;

	}

	public Long iniciaRemessaFeio(String emailDoProprietario, BigDecimal valor, String nome) {
		
		Usuario proprietario = null;
		Long id = null;		
		Remessa remessa = null;
		
		try {
			proprietario = this.usuarioDao.buscarPorEmail(emailDoProprietario);

			remessa = new Remessa();
			remessa.setNome(nome);
			remessa.setValor(valor);
			remessa.setDataAbertura(LocalDate.now());
			remessa.setUsuario(proprietario);

			id = this.remessaDao.adicionarRemessa(remessa);
		} catch (Exception e) {
			// TODO: handle exception
		}	

		this.notificadorService.notificaDonoDaRemessa(remessa);

		return id;

	}

}
