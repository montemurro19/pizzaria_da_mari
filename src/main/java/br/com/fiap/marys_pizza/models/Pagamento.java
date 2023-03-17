package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Pagamento {

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

    public Pagamento(BigDecimal valor, String tipoPagamento) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }
    
    @Override
    public String toString() {
        return "Pagamento [valor=" + valor + ", tipoPagamento=" + tipoPagamento + "]";
    }

}