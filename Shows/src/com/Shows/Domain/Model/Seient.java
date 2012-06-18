package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.Shows.TupleTypes.PosicioSeient;

@Entity
public class Seient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private AuxiliarSeient auxiliarSeient;

	public Seient() {
	}

	public Seient(Local local, int columna, int fila) {
		auxiliarSeient = new AuxiliarSeient(local, fila, columna);
	}

	public PosicioSeient seient() {
		PosicioSeient aux = new PosicioSeient(auxiliarSeient.getFila(),
				auxiliarSeient.getColumna());
		return aux;
	}

	public void setAuxiliarSeient(AuxiliarSeient auxiliarSeient) {
		this.auxiliarSeient = auxiliarSeient;
	}

	public AuxiliarSeient getAuxiliarSeient() {
		return auxiliarSeient;
	}
}
