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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Historico;
import br.com.fiap.marys_pizza.repositories.HistoricoRepository;
import jakarta.validation.Valid;

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
        return ResponseEntity.ok(getHistorico(idHistorico));
    }

    @PostMapping
    public ResponseEntity<Historico> create(@RequestBody @Valid Historico historico) {
        log.info("criar historico");
        repository.save(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }

    private Historico getHistorico(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "histórico não existente")
        );  
    }
}