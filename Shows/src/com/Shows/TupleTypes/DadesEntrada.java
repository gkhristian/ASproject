package com.Shows.TupleTypes;

import java.util.Set;

public class DadesEntrada {
	private float preu;
	private Set<String> canvis;

	public DadesEntrada(final float preu, final Set<String> canvis) {
		this.setPreu(preu);
		this.setCanvis(canvis);
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public Set<String> getCanvis() {
		return canvis;
	}

	public void setCanvis(Set<String> canvis) {
		this.canvis = canvis;
	}
}