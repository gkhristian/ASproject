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
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Representacio {

	@Id
	private AuxiliarRepresentacio auxiliarRepresentacio;
	private float preu;
	private Date data;
	private int nombreSeientsLliures;
	@OneToMany
	private Set<Entrada> entradas;
	@OneToMany
	private Set<SeientEnRepresentacio> seientsEnRepresentacio;

	public Representacio() {
	}

	public Representacio(Sessio sessio, Local nom) {
		this.setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom));
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public Representacio(Sessio sessio, Local nom, Float preu, Date data,
			Integer nombreSeientsLliures) {
		setAuxiliarRepresentacio(new AuxiliarRepresentacio(sessio, nom));
		this.preu = preu;
		this.data = data;
		this.nombreSeientsLliures = nombreSeientsLliures;
		this.seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		this.entradas = new HashSet<Entrada>();
	}

	public void createEntrada(String titol, String dni, int nombEspectadors,
			Date data, float preuTotal) {

		// TODO CHECK: COM ES SAP L'IDENTIFICADOR?????????????????????
		String identificador = ((Integer) getEntradas().size()).toString();

		Entrada e = new Entrada(identificador, dni, nombEspectadors, data,
				preuTotal, this);
		entradas.add(e);
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

	public DadesRepresentacio obteInformacio() {
		boolean est = this.esEstrena();
		DadesRepresentacio aux = new DadesRepresentacio(auxiliarRepresentacio
				.getLocal().getNom(), auxiliarRepresentacio.getSessio()
				.getSessio(), nombreSeientsLliures, est, preu);
		return aux;
	}

	public boolean esEstrena() {
		return false;
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNombreSeientsLliures() {
		return nombreSeientsLliures;
	}

	public void setNombreSeientsLliures(Integer nombreSeientsLliures) {
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
		HashSet<PosicioSeient> result = new HashSet<PosicioSeient>();
		Iterator<SeientEnRepresentacio> it = seientsEnRepresentacio.iterator();
		while (it.hasNext()) {
			PosicioSeient aux = it.next().esLliure();
			if (aux != null)
				result.add(aux);
		}
		if (result.size() < numEspectadors)
			throw new SeientsNoDisp("No hi ha suficients seients lliures");
		return result;
	}

	public int getRecarrec() {
		return 0;
	}

	public DadesEntrada obtePreu(int nombEspectadors) {
		Float comisio = ShowsCom.getInstance().getComissio();
		SetMoneda canvis = ShowsCom.getInstance().getCanvis();
		int recarrec = getRecarrec();

		// Pasar de Set Moneda a set de strings
		HashSet<String> canvi = new HashSet<String>();
		canvi.add(canvis.getDivisa1().toString());
		canvi.add(canvis.getDivisa2().toString());

		DadesEntrada resultado = new DadesEntrada(
				(this.preu + comisio + recarrec) * nombEspectadors, canvi);
		return resultado;
	}
}
