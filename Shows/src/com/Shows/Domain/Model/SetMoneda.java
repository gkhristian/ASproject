package com.Shows.Domain.Model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SetMoneda {

	@Enumerated(EnumType.STRING)
	private Moneda canvi1;
	@Enumerated(EnumType.STRING)
	private Moneda canvi2;

	public SetMoneda() {
		
	}
	
	public SetMoneda(Moneda m1, Moneda m2) {
		this.canvi1 = m1;
		this.canvi2 = m2;
	}

	public Moneda getDivisa1() {
		return canvi1;
	}

	public void setDivisa1(Moneda divisa1) {
		this.canvi1 = divisa1;
	}

	public Moneda getDivisa2() {
		return canvi2;
	}

	public void setDivisa2(Moneda divisa2) {
		this.canvi2 = divisa2;
	}
}
