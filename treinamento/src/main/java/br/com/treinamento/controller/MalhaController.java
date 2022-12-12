package br.com.treinamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.dto.MalhaDTO;
import br.com.treinamento.service.MalhaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/malhas")
public class MalhaController {
	
	private final MalhaService malhaService;
	
	@Autowired
	public MalhaController(MalhaService malhaService) {		
		this.malhaService = malhaService;
	}

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MalhaDTO cadastrarMalha(@Valid @RequestBody MalhaDTO malhaDTO) {
        return this.malhaService.cadastrarMalha(malhaDTO);
    }

	@GetMapping
    public List<MalhaDTO> retornaMalhas() {
		return this.malhaService.retornaMalhas();
	}

	@GetMapping("/{id}")
	public MalhaDTO recuperaMalhaDTOPeloId(@PathVariable Long id) {
		return this.malhaService.recuperaMalhaDTOPeloId(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletaMalhaPeloId(@PathVariable Long id) {
		this.malhaService.deletaMalhaPeloId(id);
	}
}

