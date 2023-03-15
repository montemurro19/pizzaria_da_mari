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

import br.com.fiap.marys_pizza.models.Pagamento;
import br.com.fiap.marys_pizza.models.Endereco;
import br.com.fiap.marys_pizza.models.Cliente;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {

    Logger log =  LoggerFactory.getLogger(PessoaController.class);

    List<Cliente> clientes = new ArrayList<>();
    List<Endereco> enderecos = new ArrayList<>();
    List<Pagamento> pagamentos = new ArrayList<>();

    @GetMapping("/api/cliente")
    public List<Cliente> Index() {
        return clientes;
    }
    
    @GetMapping("/api/cliente/{idCliente}")
    public ResponseEntity<Cliente> show(@PathVariable Long idCliente){
        log.info("buscar cliente com id" + idCliente);
        var clienteEncontrado = clientes
                                    .stream()
                                    .filter((c) -> {return c.getIdCliente().equals(idCliente);})
                                    .findFirst();
        if (clienteEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(clienteEncontrado.get());
    }

    @PostMapping("/api/cliente")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        log.info("criar cliente" + cliente);
        cliente.setIdCliente((long) (clientes.size() + 11));
        clientes.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("/api/cliente/{idCliente}")
    public ResponseEntity<Cliente> destroy(@PathVariable Long idCliente) {
        log.info("apagar cliente com id" + idCliente);
        var clienteEncontrado = clientes
                                    .stream()
                                    .filter((c) -> {return c.getIdCliente().equals(idCliente);})
                                    .findFirst();
        if (clienteEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        clientes.remove(clienteEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/cliente/{idCliente}")
    public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        log.info("atualizar cliente com id" + idCliente);
        var clienteEncontrado = clientes
                                    .stream()
                                    .filter((c) -> {return c.getIdCliente().equals(idCliente);})
                                    .findFirst();
        if (clienteEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        clientes.remove(clienteEncontrado.get());
        cliente.setIdCliente(idCliente);
        clientes.add(cliente);
        return ResponseEntity.ok(cliente);
    }
 
}
