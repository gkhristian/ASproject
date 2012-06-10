package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Sessio {

	@Id
	@Enumerated(EnumType.STRING)
	private TipusSessio sessio;

	public Sessio(TipusSessio sessio) {
		this.sessio = sessio;
	}
	
	public TipusSessio getSessio() {
		return sessio;
	}

	public void setSessio(TipusSessio sessio) {
		this.sessio = sessio;
	}

}
