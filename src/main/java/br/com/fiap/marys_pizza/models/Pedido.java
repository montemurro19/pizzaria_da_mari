package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @NotNull 
    @Past
    private LocalDateTime horarioPedido;

    @Min(0)
    private BigDecimal valorTotal;

    private String observacao;

    private String status;

    @OneToOne
    private Avaliacao avaliacao;

    @OneToMany(mappedBy = "pedido")
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    private Cliente cliente;
}