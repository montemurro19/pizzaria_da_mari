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

import br.com.fiap.marys_pizza.models.Pedido;
import br.com.fiap.marys_pizza.repositories.PedidoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class PedidoController {

    Logger log =  LoggerFactory.getLogger(getClass());

    @Autowired
    PedidoRepository repository;

    @GetMapping
    public List<Pedido> index(){
        return repository.findAll();
    }

    @GetMapping("{idPedido}")
    public ResponseEntity<Pedido> show(@PathVariable Long idPedido){
        log.info("buscar pedido com id" + idPedido);
        return ResponseEntity.ok(getPedido(idPedido));
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody @Valid Pedido pedido) {
        log.info("criar pedido" + pedido);
        repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @DeleteMapping("{idPedido}")
    public ResponseEntity<Pedido> destroy(@PathVariable Long idPedido) {
        log.info("deletar pedido com id" + idPedido);
        repository.delete(getPedido(idPedido));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idPedido}")
    public ResponseEntity<Pedido> update(@PathVariable Long idPedido, @RequestBody @Valid Pedido pedido) {
        log.info("atualizar pedido com id" + idPedido);
        getPedido(idPedido);
        pedido.setIdPedido(idPedido);
        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    private Pedido getPedido(Long id){
        return repository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pedido não existe")
        );
    }
}