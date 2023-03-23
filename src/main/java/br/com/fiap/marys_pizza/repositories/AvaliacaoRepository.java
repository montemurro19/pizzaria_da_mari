package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}