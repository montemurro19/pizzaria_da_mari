package br.com.fiap.marys_pizza.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @NotBlank @Pattern(regexp = "^\\S+\\s\\S+(\\s\\S+)*$")
    private String nome;
    @NotBlank @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
    private String cpf;
    @NotBlank @Email 
    private String email;
    @NotBlank @Pattern(regexp = "^\\(?\\d{2}\\)?\\s\\d{4,5}-\\d{4}$")
    private String telefone;
    @NotBlank @Size(min = 8) @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*]).+$")
    private String senha;
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String usuario;
    @NotNull @Past
    private LocalDate dataNascimento;

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
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

    protected Cliente(){
    }

    public Cliente(String nome, String cpf, String email, String telefone, String senha, String usuario,
            LocalDate dataNascimento) {
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
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", email=" + email
                + ", telefone=" + telefone + ", senha=" + senha + ", usuario=" + usuario + ", dataNascimento="
                + dataNascimento + "]";
    }
       
}
