package br.com.fiap.marys_pizza.models;

public class Avaliacao {

    private int idAvaliacao;
    private String comentario;
    private int nota;

    public int getIdAvaliacao() {
        return idAvaliacao;
    }
    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public Avaliacao(int idAvaliacao, String comentario, int nota) {
        this.idAvaliacao = idAvaliacao;
        this.comentario = comentario;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao [idAvaliacao=" + idAvaliacao + ", comentario=" + comentario + ", nota=" + nota + "]";
    }
    
}