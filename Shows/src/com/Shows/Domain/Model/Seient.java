package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.Shows.TupleTypes.PosicioSeient;

@Entity
public class Seient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private AuxiliarSeient auxs;
	
	public Seient() {
	}

	public Seient(Local local, int columna, int fila) {
		auxs = new AuxiliarSeient(local, fila, columna);
	}

	public PosicioSeient seient() {
		PosicioSeient aux = new PosicioSeient(auxs.getFila(), auxs.getColumna());
		return aux;
	}
	
	public void setAuxs(AuxiliarSeient a) {
		this.auxs = a;
	}
	
	public AuxiliarSeient getAuxs() {
		return auxs;
	}
}
