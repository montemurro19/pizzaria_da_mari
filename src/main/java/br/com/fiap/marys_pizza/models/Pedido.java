package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Pedido {
    
    private int id_pedido;
    private String itens;
    private int id_cliente;
    private String data_pedido;
    private String horario_pedido;
    private BigDecimal valor_total;
    private String observacao;

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    public String getItens() {
        return itens;
    }
    public void setItens(String itens) {
        this.itens = itens;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getData_pedido() {
        return data_pedido;
    }
    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }
    public String getHorario_pedido() {
        return horario_pedido;
    }
    public void setHorario_pedido(String horario_pedido) {
        this.horario_pedido = horario_pedido;
    }
    public BigDecimal getValor_total() {
        return valor_total;
    }
    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Pedido(int id_pedido, String itens, int id_cliente, String data_pedido, String horario_pedido,
            BigDecimal valor_total, String observacao) {
        this.id_pedido = id_pedido;
        this.itens = itens;
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.horario_pedido = horario_pedido;
        this.valor_total = valor_total;
        this.observacao = observacao;
    }
    @Override
    public String toString() {
        return "Pedido [id_pedido=" + id_pedido + ", itens=" + itens + ", id_cliente=" + id_cliente + ", data_pedido="
                + data_pedido + ", horario_pedido=" + horario_pedido + ", valor_total=" + valor_total + ", observacao="
                + observacao + "]";
    }
    
}
