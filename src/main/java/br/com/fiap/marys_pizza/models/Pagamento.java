package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Pagamento {

    private Long idPagamento;
    private BigDecimal valor;
    
    public enum tipoPagamento {Credito, Débito, Dinheiro, Ticket}

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

    public Pagamento(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento [valor=" + valor + "]";
    }

}

//falta arrumar essa classe