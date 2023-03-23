package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}