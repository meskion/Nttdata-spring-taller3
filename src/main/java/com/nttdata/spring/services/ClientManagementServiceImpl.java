package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.persistence.ClientRepository;

/**
 * Imlementacion de ClientManagementI
 * 
 * @author Manu FHD
 *
 */
@Service
public class ClientManagementServiceImpl implements ClientManagementServiceI {
	/**
	 * repositorio de cliente que consume el servicio
	 */
	@Autowired
	private ClientRepository repo;

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertNewClient(Client newClient) {

		if (newClient != null && newClient.getId() == null) {

			// Insercción del nuevo partido.
			repo.saveAndFlush(newClient);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateClient(Client updatedClient) {

		if (updatedClient != null && updatedClient.getId() != null) {

			// Insercción del nuevo partido.
			repo.saveAndFlush(updatedClient);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteClient(Client deletedClient) {

		if (deletedClient != null && deletedClient.getId() != null) {

			// Insercción del nuevo partido.
			repo.delete(deletedClient);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Client searchById(Long clientId) {

		Client result = null;
		
		if (clientId != null) {
			result = repo.findById(clientId).get();
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchAll() {

		return repo.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchByName(String name) {

		return repo.findByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchByFullName(String name, String surname1, String surname2) {

		return repo.findByNameAndFirstSurnameAndSecondSurname(name, surname1, surname2);

	}

}
