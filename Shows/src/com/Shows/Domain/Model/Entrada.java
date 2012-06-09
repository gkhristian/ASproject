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
	private Integer nombreEspectadors;
	private Date data;
	private Float preu;
	@ManyToOne
	private Representacio representacio;

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
