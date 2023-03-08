package br.com.fiap.marys_pizza.models;

public class Categoria {

    private int id_categoria;
    private int id_produto;
    private String titulo;

    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria(int id_categoria, int id_produto, String titulo) {
        this.id_categoria = id_categoria;
        this.id_produto = id_produto;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Categoria [id_categoria=" + id_categoria + ", id_produto=" + id_produto + ", titulo=" + titulo + "]";
    }
    
};