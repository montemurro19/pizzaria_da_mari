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
import java.util.ArrayList;
import java.util.List;

@RestController
public class PagamentoController {
    
    Logger log = LoggerFactory.getLogger(PagamentoController.class);

    List<Pagamento> pagamentos = new ArrayList<>();

    @GetMapping("/api/pagamento")
    public List<Pagamento> index(){
        return pagamentos;
    }

    @GetMapping("/api/pagamento/{idPagamento}")
    public ResponseEntity<Pagamento> show(@PathVariable Long idPagamento){
        log.info("buscar pagamento com id" + idPagamento);
        var pagamentoEncontrado = pagamentos
                                        .stream()
                                        .filter((p) -> {return p.getIdPagamento().equals(idPagamento);})
                                        .findFirst();
        if(pagamentoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(pagamentoEncontrado.get());
    }

    @PostMapping("/api/pagamento")
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento){
        log.info("criar pagamento" + pagamento);
        pagamento.setIdPagamento((long)(pagamentos.size() + 11));
        pagamentos.add(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
        
    }

    @DeleteMapping("/api/pagamento/{idPagamento}")
    public ResponseEntity <Pagamento> destroy (@PathVariable long idPagamento){
        log.info("apagar pagamento com id" + idPagamento);
        var pagamentoEncontrado = pagamentos
                                .stream()
                                .filter((p)-> {return p.getIdPagamento().equals(idPagamento);})
                                .findFirst();
        if (pagamentoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        pagamentos.remove(pagamentoEncontrado.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();               
    }
    @PutMapping("/api/pagamento/{idPagamento}")
    public ResponseEntity<Pagamento> update (@PathVariable Long idPagamento,@RequestBody Pagamento pagamento){
        log.info("atualizar pagamento com id" + idPagamento);
        var pagamentoEncontrado = pagamentos
                                    .stream()
                                    .filter((p)->{return p.getIdPagamento().equals(idPagamento);})
                                    .findFirst();
       if (pagamentoEncontrado.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        pagamentos.remove(pagamentoEncontrado.get());
        pagamento.setIdPagamento(idPagamento);
        pagamentos.add(pagamento);
        return ResponseEntity.ok(pagamento);                             
    }
    
}