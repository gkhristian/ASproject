package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class ShowsCom {
	@Id
	private int id;
	private int codiBanc;
	private String numeroCompte;
	private Float comissio;
	@Enumerated(EnumType.STRING)
	private Moneda divisa;
	private SetMoneda canvis;

	private static ShowsCom instance;

	public static ShowsCom getInstance() {
		return instance;
	}

	public ShowsCom(int id, int codiBanc, String numeroCompte, Float comissio,
			Moneda divisa, SetMoneda canvis) {
		this.id = id;
		this.codiBanc = codiBanc;
		this.numeroCompte = numeroCompte;
		this.comissio = comissio;
		this.divisa = divisa;
		this.setCanvis(canvis);
		instance = this;
	}

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

	public SetMoneda getCanvis() {
		return canvis;
	}

	public void setCanvis(SetMoneda canvis) {
		this.canvis = canvis;
	}
}
