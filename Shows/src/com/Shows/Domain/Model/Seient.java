package com.Shows.Domain.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	private Local local;
	@Id
	private int fila;
	@Id
	private int columna;
	
	public Seient() {
	}

	public Seient(Local local, int columna, int fila) {
		this.fila = fila;
		this.columna = columna;
		this.local = local;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
