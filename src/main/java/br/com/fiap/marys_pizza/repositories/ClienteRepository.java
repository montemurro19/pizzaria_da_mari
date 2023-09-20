package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

}