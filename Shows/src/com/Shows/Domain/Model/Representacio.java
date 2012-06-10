package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.Shows.TupleTypes.DadesRepresentacio;

@Entity
public class Representacio {

	@Id
	private AuxiliarRepresentacio auxiliarRepresentacio;
	private float preu;
	private Date data;
	private int nombreSeientsLliures;
	@OneToMany
	private Set<Entrada> entradas;
	@OneToMany
	private Set<SeientEnRepresentacio> seientsEnRepresentacio;

	public Representacio() {
	}

	public Representacio(Sessio sessio, Local nom) {
		this.setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom));
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Representacio(Sessio sessio, Local nom, Float preu, Date data,
			Integer nombreSeientsLliures) {
		setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom));
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public void createEntrada(String titol, String dni, int nombEspectadors,
			Date data, float preuTotal) {

		// TODO CHECK: COM ES SAP L'IDENTIFICADOR?????????????????????
		String identificador = ((Integer) getEntradas().size()).toString();

		Entrada e = new Entrada(identificador, dni, nombEspectadors, data,
				preuTotal, this);
		entradas.add(e);
	}

	public boolean dataOk(Date data) {
		return (data.equals(this.data));
	}

	public DadesRepresentacio obteInformacio() {
		return new DadesRepresentacio(
				auxiliarRepresentacio.getLocal().getNom(),
				auxiliarRepresentacio.getSessio().getSessio(),
				nombreSeientsLliures, false, preu);
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(Integer nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Set<SeientEnRepresentacio> getSeientsEnRepresentacio() {
		return seientsEnRepresentacio;
	}

	public void setSeientsEnRepresentacio(
			Set<SeientEnRepresentacio> seientsEnRepresentacio) {
		this.seientsEnRepresentacio = seientsEnRepresentacio;
	}

	public AuxiliarRepresentacio getAuxiliarRepresentacio() {
		return auxiliarRepresentacio;
	}

	public void setAuxiliarRepresentacio(
			AuxiliarRepresentacio auxiliarRepresentacio) {
		this.auxiliarRepresentacio = auxiliarRepresentacio;
	}
}
