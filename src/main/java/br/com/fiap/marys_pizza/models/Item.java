package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Item {

    private Long idItem;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private String tipo;

    public Long getIdItem() {
        return idItem;
    }
    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Item(String titulo, String descricao, BigDecimal preco, String tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Item [titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
                + ", tipo=" + tipo + "]";
    }
    
}
