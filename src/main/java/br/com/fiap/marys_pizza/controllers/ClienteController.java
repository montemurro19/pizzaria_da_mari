package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Cliente;
import br.com.fiap.marys_pizza.models.Credencial;
import br.com.fiap.marys_pizza.repositories.ClienteRepository;
import br.com.fiap.marys_pizza.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

    @DeleteMapping("{idCliente}")
    public ResponseEntity<Cliente> destroy(@PathVariable Long idCliente) {
        log.info("apagar cliente com id" + idCliente);
        repository.delete(getCliente(idCliente));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idCliente}")
    public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @RequestBody @Valid Cliente cliente) {
        log.info("atualizar cliente com id" + idCliente);
        getCliente(idCliente);
        cliente.setIdCliente(idCliente);
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("{idCliente}")
    private Cliente getCliente(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não existente"));
    }
}