package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {   
}