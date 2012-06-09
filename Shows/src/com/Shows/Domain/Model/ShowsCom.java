package com.Shows.Domain.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShowsCom {
	@Id
	private int id;
	private int codiBanc;
	private String numeroCompte;
	private Float comissio;
	private Moneda divisa;
	private HashSet<Moneda> canvis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodiBanc() {
		return codiBanc;
	}

	public void setCodiBanc(int codiBanc) {
		this.codiBanc = codiBanc;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Float getComissio() {
		return comissio;
	}

	public void setComissio(Float comissio) {
		this.comissio = comissio;
	}

	public Moneda getDivisa() {
		return divisa;
	}

	public void setDivisa(Moneda divisa) {
		this.divisa = divisa;
	}

	public Set<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(Set<Moneda> canvis) {
		this.canvis = (HashSet<Moneda>) canvis;
	}

}
