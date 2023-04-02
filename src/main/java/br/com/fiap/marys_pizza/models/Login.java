package br.com.fiap.marys_pizza.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Login {

    @NotEmpty
    private String usuario;
    @NotEmpty
    private String senha;

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    protected Login(){
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login [usuario=" + usuario + ", senha=" + senha + "]";
    }
     
}