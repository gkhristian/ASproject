package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Espectacle {

	@Id
	private String titol;
	private int participants;

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

}
