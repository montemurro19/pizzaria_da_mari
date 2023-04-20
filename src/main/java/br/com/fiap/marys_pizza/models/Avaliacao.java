package br.com.fiap.marys_pizza.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.marys_pizza.controllers.AvaliacaoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    @NotBlank
    @Size(min = 5)
    private String comentario;

    @NotBlank 
    @Size(min = 0, max = 10)
    private Long nota;

    @OneToOne
    private Pedido pedido;

    @OneToOne
    private Historico historico;

    public EntityModel<Avaliacao> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(AvaliacaoController.class).show(idAvaliacao)).withSelfRel(),
            linkTo(methodOn(AvaliacaoController.class).index(Pageable.unpaged(), null)).withRel("listAll")
        );
    }
}