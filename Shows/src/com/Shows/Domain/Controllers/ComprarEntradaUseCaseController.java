package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Controllers.ControllerRepresentacio;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Adapters.AdapterFactory;
import com.Shows.Domain.Adapters.IPagamentAdapter;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.Model.Representacio;
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

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	private ConsultaRepresentacioUseCaseController consultaRepresentacioUseCaseController;
	private ConsultaOcupacioUseCaseController consultaOcupacioUseCaseController;

	public Set<String> obteEspectacles() {
		IControllerEspectacle controllerEspectacle = controllerDataFactory
				.getControllerEspectacle();
		List<Espectacle> espectacles = controllerEspectacle.allEspectacles();
		Set<String> titolEspectacles = new HashSet<String>(espectacles.size());

		for (Espectacle espectacle : espectacles) {
			titolEspectacles.add(espectacle.getTitol());
		}
		return titolEspectacles;
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
		IPagamentAdapter ipa = AdapterFactory.getInstance().getPagamentAdapter();
		int codiBancShows = 0;// = Shows.com.getCodiBanc();
		String numcompteShows = "099998";// = Shows.com.getNumeroCompte();
		boolean b = ipa.autoritza(dni, codiB, numCompte, preuTotal, codiBancShows, numcompteShows);
		if(! b){
			System.out.println("Pagament no autoritzat");
		}
		else {
			IControllerRepresentacio icr = ControllerDataFactory.getInstance().getControllerRepresentacio();
			Representacio r = icr.getRepresentacio(nomLocal, sessio);
			//r.createEntrada(titol, dni, nombEspectadors, data, preuTotal);
		}
	}
}
