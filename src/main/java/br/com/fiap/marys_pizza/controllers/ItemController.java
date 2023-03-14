package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Item;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    Logger log = LoggerFactory.getLogger(ItemController.class);

    List<Item> itens = new ArrayList<>();

    @GetMapping("/api/item")
    public List<Item> index(){
        return itens;
    }
    
    @GetMapping("/api/item/{idItem}")
    public ResponseEntity<Item> show(@PathVariable Long idItem){
        log.info("buscar item com id" + idItem);
        var itemEncontrado = itens
                                .stream()
                                .filter((i) -> {return i.getIdItem().equals(idItem);})
                                .findFirst();
        if (itemEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(itemEncontrado.get());
    }

    @PostMapping("/api/item")
    public ResponseEntity<Item> create(@RequestBody Item item){
        log.info("cadastrar item" + item);
        item.setIdItem((long) (itens.size() + 11));
        itens.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping("/api/item/{idItem}")
    public ResponseEntity<Item> destroy(@PathVariable Long idItem){
        log.info("buscar item com id" + idItem);
        var itemEncontrado = itens
                                .stream()
                                .filter((i) -> {return i.getIdItem().equals(idItem);})
                                .findFirst();
        if (itemEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        itens.remove(itemEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/item/{id}")
    public ResponseEntity<Item> update(@PathVariable Long idItem, @RequestBody Item item){
        log.info("apagar item com id" + idItem);
        var itemEncontrado = itens
                                .stream()
                                .filter((i) -> {return i.getIdItem().equals(idItem);})
                                .findFirst();
        if (itemEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        itens.remove(itemEncontrado.get());
        item.setIdItem(idItem);
        itens.add(item);
        return ResponseEntity.ok(item);
    }

}    