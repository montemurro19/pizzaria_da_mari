package br.com.fiap.marys_pizza.models;

public class Historico {

    private int id_pedido;
    private String tipo_pagamento;
    private String avaliacao;
    private double valor_total;

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    public String getTipo_pagamento() {
        return tipo_pagamento;
    }
    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }
    public String getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public double getValor_total() {
        return valor_total;
    }
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Historico(int id_pedido, String tipo_pagamento, String avaliacao, double valor_total) {
        this.id_pedido = id_pedido;
        this.tipo_pagamento = tipo_pagamento;
        this.avaliacao = avaliacao;
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return "Historico [id_pedido=" + id_pedido + ", tipo_pagamento=" + tipo_pagamento + ", avaliacao=" + avaliacao
                + ", valor_total=" + valor_total + "]";
    }
    
}
