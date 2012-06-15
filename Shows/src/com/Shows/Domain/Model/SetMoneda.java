package com.Shows.Domain.Model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SetMoneda {
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<Moneda> canvis;

	public SetMoneda() {
	}

	public SetMoneda(final Set<Moneda> canvis) {
		this.setCanvis(canvis);
	}

	public Set<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(Set<Moneda> canvis) {
		this.canvis = canvis;
	}
}
