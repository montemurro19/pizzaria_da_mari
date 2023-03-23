package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {    
}