package br.com.fiap.marys_pizza.repositories;

import br.com.fiap.marys_pizza.models.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {  
    Page<Item> findByDescricaoContaining(String busca, Pageable pageable); 
}