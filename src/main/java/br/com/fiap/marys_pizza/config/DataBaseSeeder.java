package br.com.fiap.marys_pizza.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.marys_pizza.models.Cliente;
import br.com.fiap.marys_pizza.models.Item;
import br.com.fiap.marys_pizza.repositories.ClienteRepository;
import br.com.fiap.marys_pizza.repositories.ItemRepository;

    @Configuration
    public class DataBaseSeeder implements CommandLineRunner {

        @Autowired
        ItemRepository itemRepository;
        @Autowired
        ClienteRepository clienteRepository;
        
        @Override
        public void run(String... args) throws Exception {
            itemRepository.saveAll(List.of(
                new Item(1L,"pizza de calabresa","deliciosa pizza de calabresa",new BigDecimal(20),"pizza",null),
                new Item(2L,"pizza de carne","deliciosa pizza de carne",new BigDecimal(35),"pizza",null)
            ));
            clienteRepository.saveAll(List.of(
                new Cliente(1L,"Vitorio Graton","123.123.123-23","vitorio@graton.com.br","(11) 94970-0003","S3nh@c0mpl3x@","Usuario123_xyz",LocalDate.of(2004, Month.FEBRUARY, 4),null,null,null,null),
                new Cliente(2L,"Matheus Montemurro","123.143.123-23","montemurro.matheus@gmail.com","(11) 99877-6673","S3nh@c0mpl3x@","Usuario1_xyz",LocalDate.of(1998, Month.SEPTEMBER, 19),null,null,null,null)
            ));
        }

    }
