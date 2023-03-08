package br.com.fiap.marys_pizza.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.marys_pizza.models.Item;
import java.math.BigDecimal;

@RestController
public class ItemController {

    @GetMapping("/api/produto")
    public Item index(){
        Item item = new Item(
            1,
            "Pizza",
            "Pizza de pizza",
            new BigDecimal(20),
            "comida");
            
        return item;
    }  
}
