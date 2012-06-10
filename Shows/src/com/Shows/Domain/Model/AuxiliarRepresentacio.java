package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AuxiliarRepresentacio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Sessio sessio;
	@ManyToOne
	private Local local;

	public AuxiliarRepresentacio(Sessio sessio, Local nom) {
		this.sessio = sessio;
		this.local = nom;
	}

	public Sessio getSessio() {
		return sessio;
	}

	public void setSessio(Sessio sessio) {
		this.sessio = sessio;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
