package br.com.fiap.marys_pizza.models;

public class Categoria {

    private int idCategoria;
    private String titulo;

    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria(int idCategoria, String titulo) {
        this.idCategoria = idCategoria;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Categoria [idCategoria=" + idCategoria + ", titulo=" + titulo + "]";
    }
        
};