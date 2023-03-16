package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    
    private Long idPedido;
    private  LocalDateTime horarioPedido;
    private BigDecimal valorTotal;
    private String observacao;
    
    public enum status{}

    public Long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    public LocalDateTime getHorarioPedido() {
        return horarioPedido;
    }
    public void setHorarioPedido(LocalDateTime horarioPedido) {
        this.horarioPedido = horarioPedido;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Pedido(LocalDateTime horarioPedido, BigDecimal valorTotal, String observacao) {
        this.horarioPedido = horarioPedido;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Pedido [horarioPedido=" + horarioPedido + ", valorTotal=" + valorTotal
                + ", observacao=" + observacao + "]";
    }
    
}

//falta arrumar essa classe
