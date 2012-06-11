package com.Shows.Domain.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Estrena extends Representacio implements Serializable {

	private static final long serialVersionUID = 1L;

	private int recarrec;
	
	public Estrena() {
	}

	public Estrena(Sessio sessio, Local nom, int recarrec) {
		AuxiliarRepresentacio aux = new AuxiliarRepresentacio(sessio, nom);
		this.setAuxiliarRepresentacio(aux);
		this.recarrec = recarrec;
	}

	public Estrena(Sessio sessio, Local nom, float preu, Date data,
			int nombreSeientsLliures, int recarrec) {
		AuxiliarRepresentacio aux = new AuxiliarRepresentacio(sessio, nom);
		this.setAuxiliarRepresentacio(aux);
		this.setPreu(preu);
		this.setData(data);
		this.setNombreSeientsLliures(nombreSeientsLliures);
		this.recarrec = recarrec;
	}

	@Override
	public int getRecarrec() {
		return this.recarrec;
	}
	
	public void setRecarrec(int recarrec) {
		this.recarrec = recarrec;
	}
	
	@Override
	public boolean esEstrena() {
		return true;
	}
	

}