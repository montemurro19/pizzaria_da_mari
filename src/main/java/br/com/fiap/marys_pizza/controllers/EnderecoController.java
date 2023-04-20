package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.fiap.marys_pizza.models.Endereco;
import br.com.fiap.marys_pizza.repositories.EnderecoRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    EnderecoRepository repository;

    @GetMapping
    public Page<Endereco> Index(@PageableDefault(size=5)Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("{idEndereco}")
    public ResponseEntity<Endereco> show(@PathVariable Long idEndereco){
        log.info("buscar endereco com id" + idEndereco);
        return ResponseEntity.ok(getEndereco(idEndereco));
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody @Valid Endereco endereco) {
        log.info("cadastrar endereco" + endereco);
        repository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping("{idEndereco}")
    public ResponseEntity<Endereco> destroy(@PathVariable Long idEndereco) {
        log.info("apagar endereco com id" + idEndereco);
        repository.delete(getEndereco(idEndereco));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable Long idEndereco, @RequestBody @Valid Endereco endereco) {
        log.info("atualizar endereco com id" + idEndereco);
        getEndereco(idEndereco);
        repository.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    private Endereco getEndereco(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "endereço não existente")
        );  
    }
}