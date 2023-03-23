package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

import br.com.fiap.marys_pizza.models.Avaliacao;
import br.com.fiap.marys_pizza.repositories.AvaliacaoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    Logger log =  LoggerFactory.getLogger(AvaliacaoController.class);

    @Autowired
    AvaliacaoRepository repository;

    @GetMapping
    public List<Avaliacao> index(){
        return repository.findAll();
    }

    @GetMapping("{idAvaliacao}")
    public ResponseEntity<Avaliacao> show(@PathVariable Long idAvaliacao){
        log.info("buscar avaliação com id" + idAvaliacao);
        var avaliacaoEncontrada = repository.findById(idAvaliacao);
        if (avaliacaoEncontrada.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(avaliacaoEncontrada.get());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao){
        log.info("criar avaliação" + avaliacao);
        repository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping("{idAvaliacao}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long idAvaliacao, @RequestBody Avaliacao avaliacao){
        log.info("atualizar avaliação com id" + idAvaliacao);
        var avaliacaoEncontrada = repository.findById(idAvaliacao);

        if (avaliacaoEncontrada.isEmpty()) return ResponseEntity.notFound().build();

        var novaAvaliacao = avaliacaoEncontrada.get();
        BeanUtils.copyProperties(avaliacao, novaAvaliacao, "idAvaliacao");
        
        repository.save(novaAvaliacao);

        return ResponseEntity.ok(novaAvaliacao);
    } 
}
