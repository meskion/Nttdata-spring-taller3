package com.nttdata.spring.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa una entidad de la base de datos. Un cliente con sus
 * atributos que lo caracterizan.
 * 
 * @author Manu FHD
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

	// Atributos

	private static final long serialVersionUID = 8679236385915152191L;
	private Long id;
	private String name, firstSurname, secondSurname, dni;

	// Getters - Setters

	/**
	 * Id del cliente, hibernate se encarga de producirlo a traves de las
	 * anotaciones.
	 * 
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME1", nullable = false)
	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	@Column(name = "SURNAME2", nullable = false)
	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Devuelve el dni del cliente. anotado y restringido con hibernate para que sea
	 * un campo unico y con longitud 9 caracteres
	 * 
	 * @return dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return getName() + " " + getFirstSurname() + " " + getSecondSurname();
	}

}
