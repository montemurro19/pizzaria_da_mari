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
import jakarta.persistence.OneToOne;
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
    @Pattern(regexp = "^\\S+\\s\\S+(\\s\\S+)*$")
    private String nome;

    @NotBlank 
    @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")
    private String cpf;

    @NotBlank 
    @Email 
    private String email;

    @NotBlank 
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s\\d{4,5}-\\d{4}$")
    private String telefone;

    @NotBlank 
    @Size(min = 8) 
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*]).+$")
    private String senha;

    @NotBlank 
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String usuario;

    @NotNull 
    @Past
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente")
    private List<Pagamento> pagamentos = new ArrayList<>();

    @Embedded
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToOne
    private Historico historico;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();
}
