package com.Shows.TupleTypes;

public class PosicioSeient {
	private int fila;
	private int columna;

	public PosicioSeient(final int fila, final int columna) {
		this.setFila(fila);
		this.setColumna(columna);
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
}
