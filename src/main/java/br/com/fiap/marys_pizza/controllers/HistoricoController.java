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

import br.com.fiap.marys_pizza.models.Historico;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HistoricoController {

    Logger log =  LoggerFactory.getLogger(HistoricoController.class);

    List<Historico> historicos = new ArrayList<>();

    @GetMapping("/api/historico")
    public List<Historico> index(){
        return historicos;
    }

    @GetMapping("/api/historico/{idHistorico}")
    public ResponseEntity<Historico> show(@PathVariable Long idHistorico){
        log.info("buscar historico com id" + idHistorico);
        var historicoEncontrado = historicos
                                        .stream()
                                        .filter((h) -> {return h.getIdHistorico().equals(idHistorico);})
                                        .findFirst();
        if(historicoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(historicoEncontrado.get());
    }

    @PostMapping("/api/historico")
    public ResponseEntity<Historico> create(@RequestBody Historico historico) {
        log.info("criar historico");
        historico.setIdHistorico((long) (historicos.size() + 11));
        historicos.add(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }

}