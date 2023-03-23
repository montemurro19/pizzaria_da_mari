package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {   
}