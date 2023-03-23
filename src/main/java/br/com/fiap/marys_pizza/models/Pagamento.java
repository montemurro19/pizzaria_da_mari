package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;
    private BigDecimal valor;
    private String tipoPagamento;
    
    public Long getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    protected Pagamento(){
    }

    public Pagamento(BigDecimal valor, String tipoPagamento) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }
    
    @Override
    public String toString() {
        return "Pagamento [valor=" + valor + ", tipoPagamento=" + tipoPagamento + "]";
    }

}