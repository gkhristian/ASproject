package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.Domain.Model.Moneda;
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaUseCaseController {
	// TODO Replicado ====//
	private String titol;
	private Date data;
	// ===================//
	// TODO Replicado ====//
	private String nomLocal;
	private String sessio;
	private int nombEspectadors;
	// ===================//
	private Set<PosicioSeient> seients;
	private float preuTotal;

	private ConsultaRepresentacioUseCaseController consultaRepresentacioUseCaseController;
	private ConsultaOcupacioUseCaseController consultaOcupacioUseCaseController;

	public Set<String> obteEspectacles() {
		// TODO obteEspectacles...
		return new HashSet<String>();
	}

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data) {
		// Replicado...
		this.titol = titol;
		this.data = data;
		consultaRepresentacioUseCaseController = new ConsultaRepresentacioUseCaseController();
		return consultaRepresentacioUseCaseController.obteRepresentacions(
				titol, data);
	}

	public Set<PosicioSeient> obteOcupacio(String nomLocal, String sessio,
			int nombEspectadors, Date data) {
		// Replicado...
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;
		this.data = data; // TODO Es necesario???
		return consultaOcupacioUseCaseController.obteOcupacio(nomLocal, sessio,
				nombEspectadors, data);
	}

	public Set<DadesEntrada> selecionarSeients(Set<PosicioSeient> seients) {
		this.seients = seients;
		return new HashSet<DadesEntrada>();
	}

	public float obtePreuMoneda(Moneda moneda) {
		// TODO esto es así???
		this.preuTotal = 1f; // preu?
		return 0f;
	}

	public void pagament(String dni, int codiB, String numCompte, Date data) {

	}
}
