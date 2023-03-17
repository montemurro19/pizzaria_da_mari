package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
    
    private Long idPedido;
    private LocalDateTime horarioPedido;
    private BigDecimal valorTotal;
    private String observacao;
    private String status;
    
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido(LocalDateTime horarioPedido, BigDecimal valorTotal, String observacao, String status) {
        this.horarioPedido = horarioPedido;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Pedido [horarioPedido=" + horarioPedido + ", valorTotal=" + valorTotal + ", observacao=" + observacao
                + ", status=" + status + "]";
    }
    
}