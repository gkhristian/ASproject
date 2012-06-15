package com.Shows.Domain.Model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.Session;

import com.Shows.HibernateUtil;

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
		if (instance == null) {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			instance = (ShowsCom) session.get(ShowsCom.class, 1);
		}
		return instance;
	}

	public ShowsCom() {
	}

	public ShowsCom(final int id, final int codiBanc,
			final String numeroCompte, final float comissio,
			final Moneda divisa, final SetMoneda canvis) {
		this.id = id;
		this.codiBanc = codiBanc;
		this.numeroCompte = numeroCompte;
		this.comissio = comissio;
		this.divisa = divisa;
		this.canvis = canvis;
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

	public float getComissio() {
		return comissio;
	}

	public void setComissio(float comissio) {
		this.comissio = comissio;
	}

	public Moneda getDivisa() {
		return divisa;
	}

	public void setDivisa(Moneda divisa) {
		this.divisa = divisa;
	}

	public Set<String> getCanvis() {
		HashSet<String> canvis = new HashSet<String>();

		Iterator<Moneda> iterator = this.canvis.iterator();
		while (iterator.hasNext()) {
			canvis.add(iterator.next().toString());
		}

		return canvis;
	}
}
