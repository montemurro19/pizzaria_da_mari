package br.com.fiap.marys_pizza.models;

public class Avaliacao {

    private Long idAvaliacao;
    private String comentario;
    private int nota;

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }
    public void setIdAvaliacao(Long idAvaliacao) {
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
    
    public Avaliacao(String comentario, int nota) {
        this.comentario = comentario;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao [comentario=" + comentario + ", nota=" + nota + "]";
    }
    
}