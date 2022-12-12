package br.com.treinamento.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MalhaDTO {
		
    private Long id;
	
    @NotNull(message = "A ponto inferior esquerdo não pode ser nulo")
	@Valid
	private LocalizacaoDTO pontoInferiorEsquerdo;
	
    @NotNull(message = "O ponto superior direito não pode ser nulo")
	@Valid
	private LocalizacaoDTO pontoSuperiorDireito;
    
}
