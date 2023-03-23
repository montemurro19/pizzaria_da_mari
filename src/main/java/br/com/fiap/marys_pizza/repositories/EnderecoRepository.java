package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {   
}