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

import br.com.fiap.marys_pizza.models.Cliente;
import br.com.fiap.marys_pizza.repositories.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    Logger log =  LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteRepository repository;

    @GetMapping
    public List<Cliente> Index() {
        return repository.findAll();
    }
    
    @GetMapping("{idCliente}")
    public ResponseEntity<Cliente> show(@PathVariable Long idCliente){
        log.info("buscar cliente com id" + idCliente);
        var clienteEncontrado = repository.findById(idCliente);
        if (clienteEncontrado.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clienteEncontrado.get());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        log.info("criar cliente" + cliente);
        repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("{idCliente}")
    public ResponseEntity<Cliente> destroy(@PathVariable Long idCliente) {
        log.info("apagar cliente com id" + idCliente);
        var clienteEncontrado = repository.findById(idCliente);

        if (clienteEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(clienteEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idCliente}")
    public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        log.info("atualizar cliente com id" + idCliente);
        var clienteEncontrado = repository.findById(idCliente);

        if (clienteEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoCliente = clienteEncontrado.get();
        BeanUtils.copyProperties(cliente, novoCliente, "idCliente");

        repository.save(novoCliente);

        return ResponseEntity.ok(novoCliente);
    }

}
