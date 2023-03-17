package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Pedido;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController {

    Logger log =  LoggerFactory.getLogger(PedidoController.class);

    List<Pedido> pedidos = new ArrayList<>();

    @GetMapping("/api/pedido")
    public List<Pedido> index(){
        return pedidos;
    }

    @GetMapping("/api/pedido/{idPedido}")
    public ResponseEntity<Pedido> show(@PathVariable Long idPedido){
        log.info("buscar pedido com id" + idPedido);
        var pedidoEncontrado = pedidos
                                        .stream()
                                        .filter((p) -> {return p.getIdPedido().equals(idPedido);})
                                        .findFirst();
        if(pedidoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(pedidoEncontrado.get());
    }

    @PostMapping("/api/pedido")
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
        log.info("criar pedido");
        pedido.setIdPedido((long) (pedidos.size() + 11))
        pedidos.add(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @DeleteMapping("/api/pedido/{idPedido}")
    public ResponseEntity<Pedido> destroy(@PathVariable Long idPedido) {
        log.info("deletar pedido com id" + idPedido);
        var pedidoEncontrado = pedidos
                                    .stream()
                                    .filter((p) -> {return p.getIdPedido().equals(idPedido);})
                                    .findFirst();
        if(pedidoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        pedidos.remove(pedidoEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/api/pedido/{idPedido}")
    public ResponseEntity<Pedido> update(@PathVariable Long idPedido, @RequestBody Pedido pedido) {
        log.info("atualizar pedido com id" + idPedido);
        var pedidoEncontrado = pedidos
                                    .stream()
                                    .filter((p) -> {return p.getIdPedido().equals(idPedido);})
                                    .findFirst();
        if(pedidoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        pedidos.remove(pedidoEncontrado.get());
        pedido.setIdPedido(idPedido);
        pedidos.add(pedido);
        return ResponseEntity.ok(pedido);
    }

}