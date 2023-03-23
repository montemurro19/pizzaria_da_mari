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

import br.com.fiap.marys_pizza.models.Endereco;
import br.com.fiap.marys_pizza.repositories.EnderecoRepository;

import java.util.List;


@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    EnderecoRepository repository;

    @GetMapping
    public List<Endereco> index(){
        return repository.findAll();
    }

    @GetMapping("{idEndereco}")
    public ResponseEntity<Endereco> show(@PathVariable Long idEndereco){
        log.info("buscar endereco com id" + idEndereco);
        var enderecoEncontrado = repository.findById(idEndereco);
        if (enderecoEncontrado.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(enderecoEncontrado.get());
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
        log.info("cadastrar endereco" + endereco);
        repository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping("{idEndereco}")
    public ResponseEntity<Endereco> destroy(@PathVariable Long idEndereco) {
        log.info("apagar endereco com id" + idEndereco);
        var enderecoEncontrado = repository.findById(idEndereco);

        if (enderecoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(enderecoEncontrado.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable Long idEndereco, @RequestBody Endereco endereco) {
        log.info("atualizar endereco com id" + idEndereco);
        var enderecoEncontrado = repository.findById(idEndereco);

        if (enderecoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var novoEndereco = enderecoEncontrado.get();
        BeanUtils.copyProperties(endereco, novoEndereco, "idEndereco");

        repository.save(novoEndereco);
        
        return ResponseEntity.ok(novoEndereco);
    }
   
}