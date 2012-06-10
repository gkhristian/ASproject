package com.Shows.TupleTypes;

import com.Shows.Domain.Model.TipusSessio;

public class DadesRepresentacio {
	private String nomLocal;
	private TipusSessio sessio;
	private int nombreSeientsLliures;
	private boolean estrena;
	private float preu;

	public DadesRepresentacio(final String nomLocal, final TipusSessio sessio,
			final int nombreSeientsLliures, final boolean estrena,
			final float preu) {
		this.setNomLocal(nomLocal);
		this.setSessio(sessio);
		this.setNombreSeientsLliures(nombreSeientsLliures);
		this.setEstrena(estrena);
		this.setPreu(preu);
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}

	public TipusSessio getSessio() {
		return sessio;
	}

	public void setSessio(TipusSessio sessio) {
		this.sessio = sessio;
	}

	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public boolean isEstrena() {
		return estrena;
	}

	public void setEstrena(boolean estrena) {
		this.estrena = estrena;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}
}