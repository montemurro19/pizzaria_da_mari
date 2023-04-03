package br.com.fiap.marys_pizza.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Pagamento;
import br.com.fiap.marys_pizza.repositories.PagamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    
    Logger log = LoggerFactory.getLogger(PagamentoController.class);

    @Autowired
    PagamentoRepository repository;

    @GetMapping
    public List<Pagamento> index(){
        return repository.findAll();
    }

    @GetMapping("{idPagamento}")
    public ResponseEntity<Pagamento> show(@PathVariable Long idPagamento){
        log.info("buscar pagamento com id" + idPagamento);
        return ResponseEntity.ok(getPagamento(idPagamento));
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@RequestBody @Valid Pagamento pagamento){
        log.info("criar pagamento" + pagamento);
        repository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);  
    }

    @DeleteMapping("{idPagamento}")
    public ResponseEntity <Pagamento> destroy (@PathVariable long idPagamento){
        log.info("apagar pagamento com id" + idPagamento);
        repository.delete(getPagamento(idPagamento));
        return ResponseEntity.noContent().build();               
    }

    @PutMapping("{idPagamento}")
    public ResponseEntity<Pagamento> update (@PathVariable Long idPagamento,@RequestBody @Valid Pagamento pagamento){
        log.info("atualizar pagamento com id" + idPagamento);
        getPagamento(idPagamento);
        pagamento.setIdPagamento(idPagamento);
        repository.save(pagamento);
        return ResponseEntity.ok(pagamento);                             
    }
    
    private Pagamento getPagamento(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pagamento não existente")
        );  
    }
}