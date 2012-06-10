package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Adapters.AdapterFactory;
import com.Shows.Domain.Adapters.IPagamentAdapter;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.ShowsCom;
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
		// TODO esto es as�???
		this.preuTotal = 1f; // preu?
		return 0f;
	}

	public void pagament(String dni, int codiB, String numCompte, Date data) {
		IPagamentAdapter pagamentAdapter = AdapterFactory.getInstance()
				.getPagamentAdapter();
		int codiBancShows = ShowsCom.getCodiBanc();
		String numcompteShows  = ShowsCom.getNumeroCompte();
		boolean autoritzat = pagamentAdapter.autoritza(dni, codiB, numCompte, preuTotal,
				codiBancShows, numcompteShows);
		if (!autoritzat) {
			// TODO throw exception, aqu� o en el servicio (Dir�a que en el servicio)
			System.out.println("Pagament no autoritzat");
		} else {
			IControllerRepresentacio controllerRepresentacio = ControllerDataFactory
					.getInstance().getControllerRepresentacio();
			Representacio representacio = controllerRepresentacio
					.getRepresentacio(nomLocal, sessio);
			// representacio.createEntrada(titol, dni, nombEspectadors, data,
			// preuTotal);
		}
	}
}
