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
            Item pizzaCalabresa = new Item(1L,"pizza de calabresa","deliciosa pizza de calabresa",new BigDecimal(20),"pizza",null);
            Item pizzaCarne = new Item(2L,"pizza de carne","deliciosa pizza de carne",new BigDecimal(35),"pizza",null);
            Item pizzaPortuguesa = new Item(3L,"pizza de portuguesa", "deliciosa pizza de calabresa", new BigDecimal(35),"pizza",null);
            Item pizzaAtum = new Item(4L,"pizza de atum", "deliciosa pizza de atum com cebola",new BigDecimal(35),"pizza", null);
            Item cocacola1L = new Item(5L, "Coca Cola 1 Litros", "Refrigerante Coca Cola 1 Litros",new BigDecimal(35),"refrigerante",null);
            Item cocacola2L = new Item (6L,"Coca Cola 2 Litros","Refrigerante Coca Cola 2 Litros", new BigDecimal(35),"refrigerante",null);
            Item guarana1L = new Item (7L,"Guarana 1 Litros","Refrigerante Guarana 1L",new BigDecimal(35),"refrigerante",null);
            Item guarana2L = new Item (8L,"Guarana 2 Litros", "Refrigerante Guarana 2L",new BigDecimal(35),"refrigerante",null);

            itemRepository.saveAll(List.of(pizzaCalabresa, pizzaCarne, pizzaPortuguesa, pizzaAtum, cocacola1L, cocacola2L, guarana1L, guarana2L));
            
            Cliente c1 = new Cliente(1L,"Vitorio Graton","123.123.123-23","vitorio@graton.com.br","(11) 94970-0003","S3nh@c0mpl3x@","Usuario123_xyz",LocalDate.of(2004, Month.FEBRUARY, 4),null,null,null,null);
            Cliente c2 = new Cliente(2L,"Matheus Montemurro","123.143.123-23","montemurro.matheus@gmail.com","(11) 99877-6673","S3nh@c0mpl3x@","Usuario1_xyz",LocalDate.of(1998, Month.SEPTEMBER, 19),null,null,null,null);
            Cliente c3 = new Cliente(3L, "Neymar Jr","100.123.897-10","neymar.jr@gmail.com","(11)91010-6810","C4kh@b1po10j@","Neymarjr_10",LocalDate.of(1992, Month.FEBRUARY,5), null, null, null, null);
            Cliente c4 = new Cliente(4L,"Lula Inacio","133.133.133-13","luis.inacio@gmail.com","(13)91313-1313","L3pt@ptpt13l@","LulaInacio_13",LocalDate.of(1945,Month.OCTOBER,27), null, null, null, null);

            clienteRepository.saveAll(List.of(c1, c2, c3, c4));
        }

    }
