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

import br.com.fiap.marys_pizza.models.Endereco;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EnderecoController {

    Logger log = LoggerFactory.getLogger(ItemController.class);

    List<Endereco> enderecos = new ArrayList<>();

    @GetMapping("/api/endereco")
    public List<Endereco> index(){
        return enderecos;
    }

    @GetMapping("/api/endereco/{idEndereco}")
    public ResponseEntity<Endereco> show(@PathVariable Long idEndereco){
        log.info("buscar endereco com id" + idEndereco);
        var enderecoEncontrado = enderecos
                                        .stream()
                                        .filter((e) -> {return e.getIdEndereco().equals(idEndereco);})
                                        .findFirst();
        if (enderecoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(enderecoEncontrado.get());
    }

    @PostMapping("/api/endereco")
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) {
        log.info("cadastrar endereco" + endereco);
        endereco.setIdEndereco((long) (enderecos.size() + 11));
        enderecos.add(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @DeleteMapping("/api/endereco/{idEndereco}")
    public ResponseEntity<Endereco> destroy(@PathVariable Long idEndereco) {
        log.info("apagar endereco com id" + idEndereco);
        var enderecoEncontrado = enderecos
                                    .stream()
                                    .filter((e) -> {return e.getIdEndereco().equals(idEndereco);})
                                    .findFirst();
        if (enderecoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        enderecos.remove(enderecoEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/endereco/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable Long idEndereco, @RequestBody Endereco endereco) {
        log.info("atualizar endereco com id" + idEndereco);
        var enderecoEncontrado = enderecos
                                    .stream()
                                    .filter((c) -> {return c.getIdEndereco().equals(idEndereco);})
                                    .findFirst();
        if (enderecoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        enderecos.remove(enderecoEncontrado.get());
        endereco.setIdEndereco(idEndereco);
        enderecos.add(endereco);
        return ResponseEntity.ok(endereco);
    }
   
}