package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Historico;
import br.com.fiap.marys_pizza.repositories.HistoricoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    Logger log =  LoggerFactory.getLogger(HistoricoController.class);

    @Autowired
    HistoricoRepository repository;

    @GetMapping
    public List<Historico> index(){
        return repository.findAll();
    }

    @GetMapping("{idHistorico}")
    public ResponseEntity<Historico> show(@PathVariable Long idHistorico){
        log.info("buscar historico com id" + idHistorico);
        var historicoEncontrado = repository.findById(idHistorico);
        if(historicoEncontrado.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(historicoEncontrado.get());
    }

    @PostMapping
    public ResponseEntity<Historico> create(@RequestBody Historico historico) {
        log.info("criar historico");
        repository.save(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }

}