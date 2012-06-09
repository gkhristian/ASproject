package com.Shows.Domain.Model;

import javax.persistence.Entity;

@Entity
public class Estrena extends Representacio {

	private int recarrec;

	public int getRecarrec() {
		return recarrec;
	}

	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}
	
	
}
