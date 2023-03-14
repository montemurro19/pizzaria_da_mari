package br.com.fiap.marys_pizza.models;

public class Historico {
    
    private int idPedido;
    private String avaliacao;
    private double valorTotal;
    
    public enum tipoPagamento {Credito, Débito, Dinheiro, Ticket}

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Historico(int idPedido, String avaliacao, double valorTotal) {
        this.idPedido = idPedido;
        this.avaliacao = avaliacao;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Historico [idPedido=" + idPedido + ", avaliacao=" + avaliacao + ", valorTotal=" + valorTotal + "]";
    }
   
}
