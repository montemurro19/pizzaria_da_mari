package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Pagamento {

    private int idPagamento;
    private BigDecimal valor;
    
    public enum tipoPagamento {Credito, Débito, Dinheiro, Ticket}

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pagamento(int idPagamento, BigDecimal valor) {
        this.idPagamento = idPagamento;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento [idPagamento=" + idPagamento + ", valor=" + valor + "]";
    }

}
