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

import br.com.fiap.marys_pizza.models.Item;
import br.com.fiap.marys_pizza.repositories.ItemRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemRepository repository;

    @GetMapping
    public List<Item> index(){
        return repository.findAll();
    }
    
    @GetMapping("{idItem}")
    public ResponseEntity<Item> show(@PathVariable Long idItem){
        log.info("buscar item com id" + idItem);
        return ResponseEntity.ok(getItem(idItem));
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody @Valid Item item){
        log.info("cadastrar item" + item);
        repository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping("{idItem}")
    public ResponseEntity<Item> destroy(@PathVariable Long idItem){
        log.info("apagar item com id" + idItem);
        repository.delete(getItem(idItem));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idItem}")
    public ResponseEntity<Item> update(@PathVariable Long idItem, @RequestBody @Valid Item item){
        log.info("atualizar item com id" + idItem);
        getItem(idItem);
        repository.save(item);
        return ResponseEntity.ok(item);
    }

    private Item getItem(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item não existente")
        );  
    }
}    