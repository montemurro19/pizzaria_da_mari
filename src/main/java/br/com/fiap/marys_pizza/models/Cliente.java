package br.com.fiap.marys_pizza.models;

public class Cliente {

    private int id_cliente;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;
    private String usuario;
    private String data_nascimento;
    
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
    public String getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    public Cliente(int id_cliente, String nome, String cpf, String email, String telefone, String senha, String usuario,
            String data_nascimento) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.usuario = usuario;
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
                + ", telefone=" + telefone + ", senha=" + senha + ", usuario=" + usuario + ", data_nascimento="
                + data_nascimento + "]";
    }
    
}
