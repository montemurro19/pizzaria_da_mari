package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    
    private int idPedido;
    private  LocalDateTime horarioPedido;
    private BigDecimal valorTotal;
    private String observacao;
    
    public enum status{}

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
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

    public Pedido(int idPedido, LocalDateTime horarioPedido, BigDecimal valorTotal, String observacao) {
        this.idPedido = idPedido;
        this.horarioPedido = horarioPedido;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", horarioPedido=" + horarioPedido + ", valorTotal=" + valorTotal
                + ", observacao=" + observacao + "]";
    }
    
}
