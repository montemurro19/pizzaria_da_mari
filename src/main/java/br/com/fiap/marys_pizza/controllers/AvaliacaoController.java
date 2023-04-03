package br.com.fiap.marys_pizza.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Avaliacao;
import br.com.fiap.marys_pizza.repositories.AvaliacaoRepository;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    Logger log =  LoggerFactory.getLogger(getClass());

    @Autowired
    AvaliacaoRepository repository;

    @GetMapping
    public List<Avaliacao> index(){
        return repository.findAll();
    }

    @GetMapping("{idAvaliacao}")
    public ResponseEntity<Avaliacao> show(@PathVariable Long idAvaliacao){
        log.info("buscar avaliação com id" + idAvaliacao);
        return ResponseEntity.ok(getAvaliacao(idAvaliacao));
    }

    @PostMapping
    public ResponseEntity<Avaliacao> create(@RequestBody @Valid Avaliacao avaliacao){
        log.info("criar avaliação" + avaliacao);
        repository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping("{idAvaliacao}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long idAvaliacao, @RequestBody @Valid Avaliacao avaliacao){
        log.info("atualizar avaliação com id" + idAvaliacao);
        getAvaliacao(idAvaliacao);
        avaliacao.setIdAvaliacao(idAvaliacao);
        repository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    } 

    private Avaliacao getAvaliacao(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "avaliação não existente")
        );  
    }
}