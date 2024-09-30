package com.projeto.seo.controllers;

import com.projeto.seo.entities.Refeicao;
import com.projeto.seo.entities.dtos.AtualizarRefeicaoDTO;
import com.projeto.seo.entities.dtos.RefeicaoDTO;
import com.projeto.seo.services.impl.RefeicaoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/refeicoes")
public class RefeicaoController {

    @Autowired
    private RefeicaoServiceImpl refeicaoServiceImpl;

    @PostMapping
    public ResponseEntity<Refeicao> criarRefeicao(@Valid @RequestBody RefeicaoDTO refeicaoDTO) {
        Refeicao novaRefeicao = refeicaoServiceImpl.salvar(refeicaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRefeicao);
    }

    @GetMapping
    public ResponseEntity<List<Refeicao>> listarRefeicoes() {
        List<Refeicao> refeicoes = refeicaoServiceImpl.listar();
        return ResponseEntity.ok(refeicoes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Refeicao buscarClientePorId(@PathVariable("id") Long id){
        return refeicaoServiceImpl.buscarRefeicaoPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Refeição não encontrada."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refeicao> atualizarRefeicao(@PathVariable("id") Long id, @RequestBody AtualizarRefeicaoDTO refeicaoDTO) {
        refeicaoServiceImpl.atualizarRefeicao(id, refeicaoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(refeicaoServiceImpl.buscarRefeicaoPorId(id).get());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long id){
        refeicaoServiceImpl.buscarRefeicaoPorId(id)
                .map(refeicao -> {
                    refeicaoServiceImpl.deletar(refeicao.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Refeição não encontrada."));
    }
}
