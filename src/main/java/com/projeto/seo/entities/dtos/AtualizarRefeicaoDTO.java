package com.projeto.seo.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarRefeicaoDTO {

    @NotBlank(message = "O dia da semana não pode estar em branco.")
    private String dia;

    @NotNull(message = "O horário da refeição é obrigatório.")
    private LocalTime horario;

    @Size(max = 255, message = "A descrição da refeição não pode ter mais de 255 caracteres.")
    @NotBlank(message = "O descrição não pode estar em branco.")
    private String descricao;

    @NotEmpty(message = "A refeição deve conter pelo menos um alimento.")
    private List<AtualizarAlimentoDTO> alimentos;
}
