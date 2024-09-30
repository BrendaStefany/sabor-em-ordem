package com.projeto.seo.services.impl;

import com.projeto.seo.entities.Alimento;
import com.projeto.seo.entities.Refeicao;
import com.projeto.seo.entities.dtos.AtualizarRefeicaoDTO;
import com.projeto.seo.entities.dtos.RefeicaoDTO;
import com.projeto.seo.repositories.RefeicaoRepository;
import com.projeto.seo.services.RefeicaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RefeicaoServiceImpl implements RefeicaoService {

    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Autowired
    private AlimentoServiceImpl alimentoServiceImpl;

    public Refeicao salvar(RefeicaoDTO refeicaoDTO) {
        Refeicao refeicao = new Refeicao();
        refeicao.setDia(refeicaoDTO.dia());
        refeicao.setSemana(refeicaoDTO.semana());
        refeicao.setHorario(refeicaoDTO.horario());
        refeicao.setDescricao(refeicaoDTO.descricao());

        // Mapear alimentos
        List<Alimento> alimentos = refeicaoDTO.alimentos().stream().map(alimentoDTO -> {
            Alimento alimento = new Alimento();
            alimento.setNome(alimentoDTO.getNome());
            alimento.setQuantidade(alimentoDTO.getQuantidade());
            alimento.setRefeicao(refeicao);
            return alimento;
        }).collect(Collectors.toList());
        refeicao.setAlimentos(alimentos);
        return refeicaoRepository.save(refeicao);
    }

    public Optional<Refeicao> buscarRefeicaoPorId(Long id) {
        return refeicaoRepository.findById(id);
    }

    public void deletar(Long id) {
        Refeicao refeicao = refeicaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Refeição não encontrada"));
        refeicaoRepository.delete(refeicao);
    }

    public List<Refeicao> listar() {
        return refeicaoRepository.findAll();
    }

    public void atualizarRefeicao(Long id, AtualizarRefeicaoDTO refeicaoDTO) {
        Refeicao refeicaoBase = buscarRefeicaoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Refeição não encontrada."));

        refeicaoBase.setDescricao(refeicaoDTO.getDescricao());
        refeicaoBase.setHorario(refeicaoDTO.getHorario());
        refeicaoBase.setDia(refeicaoDTO.getDia());

        // Atualiza os alimentos da refeição
        if (refeicaoDTO.getAlimentos() != null) {
            alimentoServiceImpl.atualizarAlimentos(refeicaoBase, refeicaoDTO.getAlimentos());
        }

        // Salva a refeição atualizada
        refeicaoRepository.save(refeicaoBase);
    }

}
