package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Pagamento {

    private int id_pagamento;
    private int id_cliente;
    private String tipo;
    private BigDecimal valor;
    
    public int getId_pagamento() {
        return id_pagamento;
    }
    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pagamento(int id_pagamento, int id_cliente, String tipo, BigDecimal valor) {
        this.id_pagamento = id_pagamento;
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento [id_pagamento=" + id_pagamento + ", id_cliente=" + id_cliente + ", tipo=" + tipo + ", valor="
                + valor + "]";
    }
    
}
