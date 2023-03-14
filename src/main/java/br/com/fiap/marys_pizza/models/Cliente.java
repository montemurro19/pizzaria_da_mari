package br.com.fiap.marys_pizza.models;

import java.time.LocalDate;

public class Cliente {

    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String usuario;
    private LocalDate dataNascimento;

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cliente(int idCliente, String nome, String cpf, String email, String telefone, String senha, String usuario,
            LocalDate dataNascimento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.usuario = usuario;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
                + ", telefone=" + telefone + ", senha=" + senha + ", usuario=" + usuario + ", dataNascimento="
                + dataNascimento + "]";
    }
       
}
