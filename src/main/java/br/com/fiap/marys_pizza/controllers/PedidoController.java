package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Pedido;
import br.com.fiap.marys_pizza.repositories.PedidoRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping
public class PedidoController {

    Logger log =  LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    PedidoRepository repository;

    @GetMapping
    public List<Pedido> index(){
        return repository.findAll();
    }

    @GetMapping("{idPedido}")
    public ResponseEntity<Pedido> show(@PathVariable Long idPedido){
        log.info("buscar pedido com id" + idPedido);
        var pedidoEncontrado = repository.findById(idPedido);
        if(pedidoEncontrado.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pedidoEncontrado.get());
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody @Valid Pedido pedido, BindingResult result) {
        log.info("criar pedido" + pedido);
        repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @DeleteMapping("{idPedido}")
    public ResponseEntity<Pedido> destroy(@PathVariable Long idPedido) {
        log.info("deletar pedido com id" + idPedido);
        var pedidoEncontrado = repository.findById(idPedido);

        if(pedidoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(pedidoEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idPedido}")
    public ResponseEntity<Pedido> update(@PathVariable Long idPedido, @RequestBody @Valid Pedido pedido, BindingResult result) {
        log.info("atualizar pedido com id" + idPedido);
        var pedidoEncontrado = repository.findById(idPedido);
        if(pedidoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoPedido = pedidoEncontrado.get();
        BeanUtils.copyProperties(pedido, novoPedido, "idPedido");

        repository.save(novoPedido);

        return ResponseEntity.ok(novoPedido);
    }

}