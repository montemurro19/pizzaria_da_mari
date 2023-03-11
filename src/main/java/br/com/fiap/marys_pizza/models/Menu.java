package br.com.fiap.marys_pizza.models;

import java.math.BigDecimal;

public class Menu {

private String item;
private String descricao;
private BigDecimal preco;

public String getItem() {
    return item;
}
public void setItem(String item) {
    this.item = item;
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

public Menu(String item, String descricao, BigDecimal preco) {
    this.item = item;
    this.descricao = descricao;
    this.preco = preco;
}

@Override
public String toString() {
    return "Menu [item=" + item + ", descricao=" + descricao + ", preco=" + preco + "]";
}

}
