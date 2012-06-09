package com.Shows.Domain.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Local {

	@Id
	private String nom;
	private String adreca;

	@OneToMany
	private Set<Seient> seients;

	public Local(String nom, Set<Seient> seients) {
		this.nom = nom;
		this.seients = seients;
		// TODO Controlar set vacio
	}

	public Local(String nom, String adreca, Set<Seient> seients) {
		this.nom = nom;
		this.adreca = adreca;
		this.seients = seients;
		// TODO Controlar set vacio
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public Set<Seient> getSeients() {
		return seients;
	}

	public void setSeients(Set<Seient> seients) {
		this.seients = seients;
	}
}
