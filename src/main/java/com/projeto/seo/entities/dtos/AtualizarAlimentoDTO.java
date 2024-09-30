package com.projeto.seo.entities.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarAlimentoDTO extends AlimentoDTO {

    @NotNull(message = "O id do alimento é obrigatório.")
    private Long id;

}
