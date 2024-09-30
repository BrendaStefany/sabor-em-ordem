package com.projeto.seo.services;

import com.projeto.seo.entities.Refeicao;
import com.projeto.seo.entities.dtos.AtualizarRefeicaoDTO;
import com.projeto.seo.entities.dtos.RefeicaoDTO;

import java.util.List;
import java.util.Optional;

public interface RefeicaoService {

    Refeicao salvar(RefeicaoDTO refeicaoDTO);

    Optional<Refeicao> buscarRefeicaoPorId(Long id);

    void deletar(Long id);

    List<Refeicao> listar();

    void atualizarRefeicao(Long id, AtualizarRefeicaoDTO refeicaoDTO);
}
