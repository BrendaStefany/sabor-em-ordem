package com.projeto.seo.services;

import com.projeto.seo.entities.Alimento;
import com.projeto.seo.entities.Refeicao;
import com.projeto.seo.entities.dtos.AtualizarAlimentoDTO;

import java.util.List;
import java.util.Optional;

public interface AlimentoService {

    Alimento salvar(Alimento alimento);

    Optional<Alimento> buscarAlimentoPorId(Long id);

    void atualizarAlimentos(Refeicao refeicaoBase, List<AtualizarAlimentoDTO> alimentosDTO);

}
