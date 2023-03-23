package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}