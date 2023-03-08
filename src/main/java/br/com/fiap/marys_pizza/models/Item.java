package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Item {

    private int id_item;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private String tipo;
    
    public int getId_item() {
        return id_item;
    }
    public void setId_item(int id_item) {
        this.id_item = id_item;
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

    public Item(int id_item, String titulo, String descricao, BigDecimal preco, String tipo) {
        this.id_item = id_item;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Item [id_item=" + id_item + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
                + ", tipo=" + tipo + "]";
    } 
    
}
