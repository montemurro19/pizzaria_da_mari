package br.com.fiap.marys_pizza.models;

public class Avaliacao {

    private int id_avaliacao;
    private int id_cliente;
    private String comentario;
    private int nota;
    
    public int getId_avaliacao() {
        return id_avaliacao;
    }
    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
    
    public Avaliacao(int id_avaliacao, int id_cliente, String comentario, int nota) {
        this.id_avaliacao = id_avaliacao;
        this.id_cliente = id_cliente;
        this.comentario = comentario;
        this.nota = nota;
    }
    @Override
    public String toString() {
        return "Avaliacao [id_avaliacao=" + id_avaliacao + ", id_cliente=" + id_cliente + ", comentario=" + comentario
                + ", nota=" + nota + "]";
    }
 
}
