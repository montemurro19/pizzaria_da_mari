package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.marys_pizza.controllers.ItemController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @Min(0)
    private BigDecimal preco;

    @NotEmpty
    private String tipo;
    
    @ManyToOne
    private Pedido pedido;

    public EntityModel<Item> toModel(){
        return EntityModel.of(
            this,
            linkTo(methodOn(ItemController.class).show(idItem)).withSelfRel(),
            linkTo(methodOn(ItemController.class).destroy(idItem)).withRel("delete"),
            linkTo(methodOn(ItemController.class).index(Pageable.unpaged(), null)).withRel("listAll")
        );
    }
}
