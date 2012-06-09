package com.Shows.Domain.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sessio {

	@Id
	private TipusSessio sessio;

	public TipusSessio getSessio() {
		return sessio;
	}

	public void setSessio(TipusSessio sessio) {
		this.sessio = sessio;
	}

}
