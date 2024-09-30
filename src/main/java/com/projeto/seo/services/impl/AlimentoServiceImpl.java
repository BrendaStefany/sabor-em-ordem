package com.projeto.seo.services.impl;

import com.projeto.seo.entities.Alimento;
import com.projeto.seo.entities.Refeicao;
import com.projeto.seo.entities.dtos.AtualizarAlimentoDTO;
import com.projeto.seo.repositories.AlimentoRepository;
import com.projeto.seo.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoServiceImpl implements AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public Alimento salvar(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public Optional<Alimento> buscarAlimentoPorId(Long id) {
        return alimentoRepository.findById(id);
    }

    public void atualizarAlimentos(Refeicao refeicaoBase, List<AtualizarAlimentoDTO> alimentosDTO) {
        for (AtualizarAlimentoDTO alimentoDTO : alimentosDTO) {
            Alimento alimentoBase = buscarAlimentoPorId(alimentoDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException(("Alimento com NOME: " + alimentoDTO.getNome() + " não encontrado.")));

            alimentoBase.setQuantidade(alimentoDTO.getQuantidade());
            alimentoBase.setNome(alimentoDTO.getNome());

            alimentoRepository.save(alimentoBase);
        }
    }
}
