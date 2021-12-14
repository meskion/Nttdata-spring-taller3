package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.persistence.Client;

/**
 * Clase Servicio que maneja las instancias de Cliente
 * 
 * @author Manu FHD
 *
 */
public interface ClientManagementServiceI {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Actualiza el cliente
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Elimina el cliente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Busca por ID un cliente
	 * 
	 * @param clientId
	 * @return
	 */
	public Client searchById(final Long clientId);

	/**
	 * Da una lista con todos los clientes
	 * 
	 * @return lista de clientes
	 */
	public List<Client> searchAll();

	/**
	 * Da una lista con los clientes con el nombre dado
	 * 
	 * @param name
	 * @return
	 */
	public List<Client> searchByName(final String name);

	/**
	 * da una lista con los clientes con el nombre y apellidos dados
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return
	 */
	public List<Client> searchByFullName(String name, String surname1, String surname2);

}
