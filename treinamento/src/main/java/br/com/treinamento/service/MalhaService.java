package br.com.treinamento.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.dto.MalhaDTO;
import br.com.treinamento.repository.MalhaRepository;

@Service
public class MalhaService {	
	
	private final MalhaRepository malhaRepository;
	
	@Autowired 
	public MalhaService(MalhaRepository malhaRepository) {		
		this.malhaRepository = malhaRepository;
	}

	public MalhaDTO cadastrarMalha(@Valid MalhaDTO malhaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MalhaDTO> retornaMalhas() {
		// TODO Auto-generated method stub
		return null;
	}

	public MalhaDTO recuperaMalhaDTOPeloId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletaMalhaPeloId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	


}
