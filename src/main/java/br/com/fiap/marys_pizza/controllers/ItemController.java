package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

import br.com.fiap.marys_pizza.models.Item;
import br.com.fiap.marys_pizza.repositories.ItemRepository;

import java.util.List;

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
        var itemEncontrado = repository.findById(idItem);
        if (itemEncontrado.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(itemEncontrado.get());
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item){
        log.info("cadastrar item" + item);
        repository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping("{idItem}")
    public ResponseEntity<Item> destroy(@PathVariable Long idItem){
        log.info("apagar item com id" + idItem);
        var itemEncontrado = repository.findById(idItem);

        if (itemEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(itemEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idItem}")
    public ResponseEntity<Item> update(@PathVariable Long idItem, @RequestBody Item item){
        log.info("atualizar item com id" + idItem);
        var itemEncontrado = repository.findById(idItem);

        if (itemEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoItem = itemEncontrado.get();
        BeanUtils.copyProperties(item, novoItem, "idItem");

        repository.save(novoItem);

        return ResponseEntity.ok(novoItem);
    }

}    