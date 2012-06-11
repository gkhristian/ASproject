package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.Shows.Domain.Exception.noHiHaRepresentacions;
import com.Shows.TupleTypes.DadesRepresentacio;

@Entity
public class Espectacle {

	@Id
	private String titol;
	private int participants;
	@OneToMany
	private Set<Representacio> representacions;

	public Espectacle() {
	}

	public Espectacle(String titol, Set<Representacio> representacions) {
		this.titol = titol;
		this.representacions = representacions;
	}

	public Espectacle(String titol, int participants,
			Set<Representacio> representacions) {
		this.titol = titol;
		this.participants = participants;
		this.representacions = representacions;
	}

	public Set<DadesRepresentacio> obteRep(Date data)
			throws noHiHaRepresentacions {
		if (this.representacions.size() == 0)
			throw new noHiHaRepresentacions("No hi ha representacions");
		HashSet<DadesRepresentacio> dadesRepresentacios = new HashSet<DadesRepresentacio>();
		for (Representacio representacio : representacions) {
			if (representacio.dataOk(data))
				dadesRepresentacios.add(representacio.obteInformacio());
		}

		return dadesRepresentacios;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public Set<Representacio> getRepresentacio() {
		return representacions;
	}

	public void setRepresentacio(Set<Representacio> representacions) {
		this.representacions = representacions;
	}

}