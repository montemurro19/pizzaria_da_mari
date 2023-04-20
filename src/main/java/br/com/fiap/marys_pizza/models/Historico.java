package br.com.fiap.marys_pizza.models;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.marys_pizza.controllers.HistoricoController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;

    @Min(0)
    private double valorTotal;

    @ManyToOne
    private Pagamento pagamento;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Avaliacao avaliacao;

    public EntityModel<Historico> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(HistoricoController.class).show(idHistorico)).withSelfRel(),
            linkTo(methodOn(HistoricoController.class).index(Pageable.unpaged(), null)).withRel("listAll")

        );

    }
}
