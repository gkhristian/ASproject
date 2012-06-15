package com.Shows.Domain.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AuxiliarRepresentacio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Sessio sessio;
	@ManyToOne
	private Local local;
	
	private Date data;
	
	public AuxiliarRepresentacio() {
	}

	public AuxiliarRepresentacio(Sessio sessio, Local local, Date data) {
		this.sessio = sessio;
		this.local = local;
		this.data = data;
	}
	
	@SuppressWarnings("deprecation")
	public boolean dataOk(Date data) {
		if (this.data.getYear() != data.getYear())
			return false;
		if (this.data.getMonth() != data.getMonth())
			return false;
		if (this.data.getDay() != data.getDay())
			return false;
		return true;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
