package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    ItemRepository itemRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@PageableDefault(size = 8) Pageable pageable, @RequestParam(required = false) String busca){
        Page<Item> page = (busca == null) ?
            itemRepository.findAll(pageable) : 
            itemRepository.findByIdItemContaining(busca, pageable);

        return assembler.toModel(page.map(Item::toModel));
    }
    
    @GetMapping("{idItem}")
    public EntityModel<Item> show(@PathVariable Long idItem){
        log.info("buscar item com id" + idItem);
        var item = itemRepository.findById(idItem).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item não existente")
        );
        return item.toModel();
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody @Valid Item item){
        log.info("cadastrar item" + item);
        itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @DeleteMapping("{idItem}")
    public ResponseEntity<Item> destroy(@PathVariable Long idItem){
        log.info("apagar item com id" + idItem);
        itemRepository.delete(getItem(idItem));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idItem}")
    public ResponseEntity<Item> update(@PathVariable Long idItem, @RequestBody @Valid Item item){
        log.info("atualizar item com id" + idItem);
        getItem(idItem);
        item.setIdItem(idItem);
        itemRepository.save(item);
        return ResponseEntity.ok(item);
    }

    private Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item não existente")
        );  
    }
}    