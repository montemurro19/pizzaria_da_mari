package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;
    @NotBlank
    private String avaliacao;
    @Min(0)
    private double valorTotal;
    @NotBlank
    private String tipoPagamento;
    
    public Long getIdHistorico() {
        return idHistorico;
    }
    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }
    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    protected Historico(){
    }
    
    public Historico(String avaliacao, double valorTotal, String tipoPagamento) {
        this.avaliacao = avaliacao;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Historico [avaliacao=" + avaliacao + ", valorTotal=" + valorTotal + ", tipoPagamento=" + tipoPagamento
                + "]";
    }

}
