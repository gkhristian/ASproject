package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AuxiliarSeient implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Local local;
	private int fila;
	private int columna;

	public AuxiliarSeient() {
	}
	
	public AuxiliarSeient(Local local, int fila, int columna) {
		this.local = local;
		this.fila = fila;
		this.columna = columna;
	}
	
	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
