package com.projeto.seo.entities.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlimentoDTO {

    @NotBlank(message = "O nome do alimento não pode estar em branco.")
    private String nome;
    @NotNull(message = "A quantidade do alimento é obrigatória.")
    @DecimalMin(value = "0.1", message = "A quantidade do alimento deve ser maior que 0.")
    private Double quantidade;

}

