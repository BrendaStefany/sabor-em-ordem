package com.projeto.seo.entities.dtos;

import jakarta.validation.constraints.*;
import java.time.LocalTime;
import java.util.List;

public record RefeicaoDTO(
        @NotBlank(message = "O dia da semana não pode estar em branco.")
        String dia,

        @Min(value = 1, message = "A semana deve ser entre 1 e 4.")
        @Max(value = 4, message = "A semana deve ser entre 1 e 4.")
        int semana,

        @NotNull(message = "O horário da refeição é obrigatório.")
        LocalTime horario,

        @Size(max = 255, message = "A descrição da refeição não pode ter mais de 255 caracteres.")
        @NotBlank(message = "O descrição não pode estar em branco.")
        String descricao,

        @NotEmpty(message = "A refeição deve conter pelo menos um alimento.")
        List<AlimentoDTO> alimentos
){}
