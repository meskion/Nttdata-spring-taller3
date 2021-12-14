package com.nttdata.spring.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repositorio para la entidad clientes
 * 
 * @author Manuel Fdez
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	public List<Client> findByName(String name);

	public List<Client> findByNameAndFirstSurnameAndSecondSurname(String name, String surname1, String surname2);

	
}
