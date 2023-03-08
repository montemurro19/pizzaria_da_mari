package br.com.fiap.marys_pizza.models;

public class Status_pedido {

    private int id_pedido;
    private String descricao;
    private String status;

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Status_pedido(int id_pedido, String descricao, String status) {
        this.id_pedido = id_pedido;
        this.descricao = descricao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status_pedido [id_pedido=" + id_pedido + ", descricao=" + descricao + ", status=" + status + "]";
    }
   
}
