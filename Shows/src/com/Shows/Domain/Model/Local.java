package com.Shows.Domain.Model;

import java.util.HashSet;
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

	public Local() {
	}

	public Local(String nom) {
		this.nom = nom;
		this.seients = new HashSet<Seient>();
	}

	public Local(String nom, String adreca) {
		this.nom = nom;
		this.adreca = adreca;
		this.seients = new HashSet<Seient>();
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
