package br.com.fiap.marys_pizza.models;

public class EnderecoCliente {

    private int id_endereco;
    private int id_cliente;
    private String titulo;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String referencia;
    
    public int getId_endereco() {
        return id_endereco;
    }
    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public EnderecoCliente(int id_endereco, int id_cliente, String titulo, String logradouro, String numero,
            String bairro, String cep, String cidade, String referencia) {
        this.id_endereco = id_endereco;
        this.id_cliente = id_cliente;
        this.titulo = titulo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "EnderecoCliente [id_endereco=" + id_endereco + ", id_cliente=" + id_cliente + ", titulo=" + titulo
                + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep
                + ", cidade=" + cidade + ", referencia=" + referencia + "]";
    }
    
}
