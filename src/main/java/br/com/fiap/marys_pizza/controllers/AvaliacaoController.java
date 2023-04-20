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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.marys_pizza.models.Avaliacao;
import br.com.fiap.marys_pizza.repositories.AvaliacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    Logger log =  LoggerFactory.getLogger(getClass());

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false) String busca){
        Page<Avaliacao> page = (busca == null) ?
            avaliacaoRepository.findAll(pageable) : 
            avaliacaoRepository.findByDescricaoContaining(busca, pageable);

        return assembler.toModel(page.map(Avaliacao::toModel));
    }

    @GetMapping("{idAvaliacao}")
    public EntityModel<Avaliacao> show(@PathVariable Long idAvaliacao){
        log.info("buscar avaliação com id" + idAvaliacao);
        var avaliacao = avaliacaoRepository.findById(idAvaliacao).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "avaliação não encopntrada")
        );

        return avaliacao.toModel();
    }

    @PostMapping
    public ResponseEntity<Avaliacao> create(@RequestBody @Valid Avaliacao avaliacao){
        log.info("criar avaliação" + avaliacao);
        avaliacaoRepository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping("{idAvaliacao}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long idAvaliacao, @RequestBody @Valid Avaliacao avaliacao){
        log.info("atualizar avaliação com id" + idAvaliacao);
        getAvaliacao(idAvaliacao);
        avaliacao.setIdAvaliacao(idAvaliacao);
        avaliacaoRepository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    } 

    private Avaliacao getAvaliacao(Long id) {
        return avaliacaoRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "avaliação não existente")
        );  
    }
}