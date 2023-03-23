package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    protected Pedido(){
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