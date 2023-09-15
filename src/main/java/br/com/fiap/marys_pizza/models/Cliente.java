package br.com.fiap.marys_pizza.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank 
    private String nome;

    @NotBlank 
    private String cpf;

    @NotBlank 
    @Email 
    private String email;

    @NotBlank 
    private String telefone;

    @NotBlank 
    @Size(min = 8) 
    private String senha;

    @NotBlank 
    private String usuario;

    @NotNull 
    @Past
    private LocalDate dataNascimento;

    @Embedded
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();
}
