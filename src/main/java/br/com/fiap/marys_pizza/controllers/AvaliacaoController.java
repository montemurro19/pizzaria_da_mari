package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Avaliacao;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AvaliacaoController {

    Logger log =  LoggerFactory.getLogger(AvaliacaoController.class);

    List<Avaliacao> avaliacoes = new ArrayList<>();

    @GetMapping("/api/avaliacao")
    public List<Avaliacao> index(){
        return avaliacoes;
    }

    @GetMapping("/api/avaliacao/{idAvaliacao}")
    public ResponseEntity<Avaliacao> show(@PathVariable Long idAvaliacao){
        log.info("buscar avaliação com id" + idAvaliacao);
        var avaliacaoEncontrada = avaliacoes
                                        .stream()
                                        .filter((a) -> {return a.getIdAvaliacao().equals(idAvaliacao);})
                                        .findFirst();
        if (avaliacaoEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(avaliacaoEncontrada.get());
    }

    @PostMapping("/api/avaliacao")
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao){
        log.info("criar avaliação" + avaliacao);
        avaliacao.setIdAvaliacao((long) (avaliacoes.size() + 11));
        avaliacoes.add(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping("/api/avaliacao/{idAvaliacao}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long idAvaliacao, @RequestBody Avaliacao avaliacao){
        log.info("atualizar avaliação com id" + idAvaliacao);
        var avaliacaoEncontrada = avaliacoes
                                        .stream()
                                        .filter((a) -> {return a.getIdAvaliacao().equals(idAvaliacao);})
                                        .findFirst();
        if (avaliacaoEncontrada.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        avaliacoes.remove(avaliacaoEncontrada.get());
        avaliacao.setIdAvaliacao(idAvaliacao);
        avaliacoes.add(avaliacao);
        return ResponseEntity.ok(avaliacao);
    } 
}
