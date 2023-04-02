package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    @NotBlank
    private String titulo;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 99999-999")    
    private String cep;
    @NotBlank
    private String cidade;
    private String referencia;
    
    public Long getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
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

    protected Endereco(){
    }

    public Endereco(String titulo, String logradouro, String numero, String bairro, String cep,
            String cidade, String referencia) {
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
        return "EnderecoCliente [titulo=" + titulo + ", logradouro=" + logradouro
                + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", referencia="
                + referencia + "]";
    }

}
