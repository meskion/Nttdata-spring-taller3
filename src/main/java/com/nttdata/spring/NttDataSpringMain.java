package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.services.ClientManagementServiceI;

@SpringBootApplication
public class NttDataSpringMain implements CommandLineRunner {
	
	@Autowired
	private ClientManagementServiceI service;

	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/* Creacion de clientes de prueba*/
		Client c1 = new Client();
		c1.setDni("474383212");
		c1.setName("Manuel");
		c1.setFirstSurname("Fernandez de Heredia");
		c1.setSecondSurname("Delgado");
		
		Client c2 = new Client();
		c2.setDni("345457765");
		c2.setName("Lourdes");
		c2.setFirstSurname("Navarro");
		c2.setSecondSurname("Tocon");
		
		/* los metemos en la base de datos con el servicio*/
		service.insertNewClient(c1);
		service.insertNewClient(c2);
		
		/* Consumimos los diferentes metodos del servicio*/
		
		
		service.searchByFullName("Manuel", "Fernandez de Heredia", "Delgado").forEach(System.out::println);
		System.out.println("--------------");
		
		System.out.println(service.searchById(2L));
		System.out.println("--------------");
		
		service.searchByName("Manuel").forEach(System.out::println);
		
		c2.setName("Pedro");
		
		service.updateClient(c2);
		service.deleteClient(c1);

		service.searchAll().forEach(System.out::println);
		System.out.println("--------------");
		
		
	}

}
