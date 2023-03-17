package br.com.fiap.marys_pizza.models;

public class Historico {
    
    private Long idHistorico;
    private String avaliacao;
    private double valorTotal;
    private String tipoPagamento;
    
    public Long getIdHistorico() {
        return idHistorico;
    }
    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
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
    public String getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public Historico(String avaliacao, double valorTotal, String tipoPagamento) {
        this.avaliacao = avaliacao;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Historico [avaliacao=" + avaliacao + ", valorTotal=" + valorTotal + ", tipoPagamento=" + tipoPagamento
                + "]";
    }

}
