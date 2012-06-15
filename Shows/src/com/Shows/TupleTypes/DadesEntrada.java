package com.Shows.TupleTypes;

import java.util.Set;

import com.Shows.Domain.Model.Moneda;

public class DadesEntrada {
	private float preu;
	private Set<Moneda> canvis;

	public DadesEntrada(final float preu, final Set<Moneda> canvis) {
		this.setPreu(preu);
		this.setCanvis(canvis);
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public Set<Moneda> getCanvis() {
		return canvis;
	}

	public void setCanvis(Set<Moneda> canvis) {
		this.canvis = canvis;
	}
}