package br.com.fiap.marys_pizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Historico;
import br.com.fiap.marys_pizza.repositories.HistoricoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    Logger log =  LoggerFactory.getLogger(HistoricoController.class);

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@PageableDefault(size=5) Pageable pageable,@RequestParam(required=false) String busca){
        Page<Historico> page = (busca == null) ?
            historicoRepository.findAll(pageable) :
            historicoRepository.findByDescricaoContaining(busca,pageable);
        
        return assembler.toModel(page.map(Historico::toModel));
    }

    @GetMapping("{idHistorico}")
    public EntityModel<Historico> show(@PathVariable Long idHistorico){
        log.info("buscar historico com id" + idHistorico);
        var historico = historicoRepository.findById(idHistorico).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"histórico não encontardo")
        );
        return historico.toModel();
    }

    @PostMapping
    public ResponseEntity<Historico> create(@RequestBody @Valid Historico historico) {
        log.info("criar historico" + historico);
        historicoRepository.save(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }
}