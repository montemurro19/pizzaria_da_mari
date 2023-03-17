package br.com.fiap.marys_pizza.models;

public class Avaliacao {

    private Long idAvaliacao;
    private String comentario;
    private Long nota;

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
    public Long getNota() {
        return nota;
    }
    public void setNota(Long nota) {
        this.nota = nota;
    }
    
    public Avaliacao(String comentario, Long nota) {
        this.comentario = comentario;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao [comentario=" + comentario + ", nota=" + nota + "]";
    }
    
}