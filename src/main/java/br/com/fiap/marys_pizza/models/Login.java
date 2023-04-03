package br.com.fiap.marys_pizza.models;

import org.springframework.stereotype.Controller;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class Login {

    @NotEmpty
    private String usuario;

    @NotEmpty
    private String senha;
     
}