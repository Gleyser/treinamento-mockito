package br.com.treinamento.service;

import org.springframework.stereotype.Service;

import br.com.treinamento.model.Honra;
import br.com.treinamento.model.Remessa;

@Service
public class NotificadorService {
	
	public void notificaDonoDaRemessa(Remessa remessa) {

		String email = String.format("Prezado {}! A remessa {} com data de abertura {}, contem o valor de R${}",
				remessa.getUsuario(), remessa.getNome(), remessa.getDataAbertura(), remessa.getValor());

		System.out.println(email);

	}
	
	public void enviaBalancoDeHonra(Honra honra) {
		
		Remessa remessa = honra.getRemessa();

		String email = String.format("Prezado {}! A honra {} com data de {}, contem o valor de balanco R${}",
				remessa.getUsuario(), honra.getId(), honra.getData(), honra.retornaBalancoDaHonra());

		System.out.println(email);

	}

}
