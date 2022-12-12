package br.com.treinamento.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoDTO {
		
	@Min(value = 0, message="A coordenada X deve possuir valor igual ou maior a 0")
	@NotNull(message = "A coordenada X não pode ser nulo")
    private Integer coordenadaX;
	
	@Min(value = 0, message="A coordenada Y deve possuir valor igual ou maior a 0")
	@NotNull(message = "A coordenada Y não pode ser nulo")
    private Integer coordenadaY;


}