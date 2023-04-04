package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}