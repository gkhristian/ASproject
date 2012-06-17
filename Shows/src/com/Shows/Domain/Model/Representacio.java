package com.Shows.Domain.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Representacio {

	@Id
	private AuxiliarRepresentacio auxiliarRepresentacio;
	private float preu;
	private int nombreSeientsLliures;
	@OneToMany
	private Set<Entrada> entradas;
	@OneToMany
	private Set<SeientEnRepresentacio> seientsEnRepresentacio;

	public Representacio() {
	}

	public Representacio(Sessio sessio, Local nom, Date data) {
		this.setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom,
				data));
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Representacio(Sessio sessio, Local nom, Float preu, Date data,
			int nombreSeientsLliures) {
		setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom, data));
		this.preu = preu;
		this.nombreSeientsLliures = nombreSeientsLliures;
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Entrada createEntrada(String titol, String dni, int nombEspectadors,
			Date data, float preuTotal) {

		String identificador = titol
				+ ((Integer) getEntradas().size()).toString();

		Entrada entrada = new Entrada(identificador, dni, nombEspectadors,
				data, preuTotal, this);

		entradas.add(entrada);
		return entrada;
	}

	public boolean dataOk(Date data) {
		return auxiliarRepresentacio.dataOk(data);
	}

	public DadesRepresentacio obteInformacio() {
		return new DadesRepresentacio(
				auxiliarRepresentacio.getLocal().getNom(),
				auxiliarRepresentacio.getSessio().getSessio(),
				nombreSeientsLliures, esEstrena(), obtePreu());
	}

	public boolean esEstrena() {
		return false;
	}

	public float obtePreu() {
		return preu;
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public int getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(int nombreSeientsLliures) {
		this.nombreSeientsLliures = nombreSeientsLliures;
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Set<SeientEnRepresentacio> getSeientsEnRepresentacio() {
		return seientsEnRepresentacio;
	}

	public void setSeientsEnRepresentacio(
			Set<SeientEnRepresentacio> seientsEnRepresentacio) {
		this.seientsEnRepresentacio = seientsEnRepresentacio;
	}

	public AuxiliarRepresentacio getAuxiliarRepresentacio() {
		return auxiliarRepresentacio;
	}

	public void setAuxiliarRepresentacio(
			AuxiliarRepresentacio auxiliarRepresentacio) {
		this.auxiliarRepresentacio = auxiliarRepresentacio;
	}

	public Set<PosicioSeient> obteLliures(int numEspectadors)
			throws SeientsNoDisp {

		HashSet<PosicioSeient> posicioSeients = new HashSet<PosicioSeient>();
		Iterator<SeientEnRepresentacio> it = seientsEnRepresentacio.iterator();

		while (it.hasNext()) {
			PosicioSeient aux = it.next().esLliure();
			if (aux != null)
				posicioSeients.add(aux);
		}

		if (nombreSeientsLliures < numEspectadors)
			throw new SeientsNoDisp("No hi ha suficients seients lliures");

		return posicioSeients;
	}

	public int getRecarrec() {
		return 0;
	}
}
