package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Historico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {   

    Page<Historico> findByDescricaoContaining(String busca, Pageable pageable);

}