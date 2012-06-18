package com.Shows.Domain.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entrada {
	@Id
	private String identificador;
	private String dniClient;
	private int nombreEspectadors;
	private Date data;
	private Float preu;
	@ManyToOne
	private Representacio representacio;

	public Entrada() {
	}

	public Entrada(String identificador, Representacio representacio) {
		this.identificador = identificador;
		this.representacio = representacio;
	}

	public Entrada(String identificador, String dniClient,
			int nombreEspectadors, Date data, Float preu,
			Representacio representacio) {
		this.identificador = identificador;
		this.dniClient = dniClient;
		this.nombreEspectadors = nombreEspectadors;
		this.data = data;
		this.preu = preu;
		this.representacio = representacio;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDniClient() {
		return dniClient;
	}

	public void setDniClient(String dniClient) {
		this.dniClient = dniClient;
	}

	public Integer getNombreEspectadors() {
		return nombreEspectadors;
	}

	public void setNombreEspectadors(Integer nombreEspectadors) {
		this.nombreEspectadors = nombreEspectadors;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public Representacio getRepresentacio() {
		return representacio;
	}

	public void setRepresentacio(Representacio representacio) {
		this.representacio = representacio;
	}
}
