package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Shows.HibernateUtil;
import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Adapters.AdapterFactory;
import com.Shows.Domain.Adapters.IConversorAdapter;
import com.Shows.Domain.Adapters.IPagamentAdapter;
import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.Entrada;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.ShowsCom;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.TupleTypes.DadesEntrada;
import com.Shows.TupleTypes.DadesRepresentacio;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaUseCaseController {

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

	public Set<DadesRepresentacio> obteRepresentacions(final String titol,
			final Date data) throws NoHiHaRepresentacions {

		consultaRepresentacioUseCaseController = new ConsultaRepresentacioUseCaseController();
		return consultaRepresentacioUseCaseController.obteRepresentacions(
				titol, data);
	}

	public Set<PosicioSeient> obteOcupacio(final String nomLocal,
			final TipusSessio sessio, final int nombEspectadors)
			throws SeientsNoDisp {// , Date data) {

		consultaOcupacioUseCaseController = new ConsultaOcupacioUseCaseController();

		return consultaOcupacioUseCaseController.obteOcupacio(nomLocal, sessio,
				nombEspectadors,
				consultaRepresentacioUseCaseController.getData());
	}

	public DadesEntrada selecionarSeients(final Set<PosicioSeient> seients) {
		this.seients = seients;

		IControllerRepresentacio controllerRepresentacio = controllerDataFactory
				.getControllerRepresentacio();

		Representacio representacio = controllerRepresentacio.getRepresentacio(
				consultaOcupacioUseCaseController.getNomLocal(),
				consultaOcupacioUseCaseController.getSessio(),
				consultaRepresentacioUseCaseController.getData());

		/*
		 * DadesEntrada dadesEntrada = representacio
		 * .obtePreu(consultaOcupacioUseCaseController.getNombEspectadors());
		 */

		// SetMoneda canvis = ShowsCom.getInstance().getCanvis();

		// Pasar de Set Moneda a Set de Strings
		/*
		 * HashSet<String> canvi = new HashSet<String>();
		 * canvi.add(canvis.getDivisa1().toString());
		 * canvi.add(canvis.getDivisa2().toString());
		 */

		DadesEntrada dadesEntrada = new DadesEntrada(
				(this.preuTotal + ShowsCom.getInstance().getComissio() + representacio
						.getRecarrec())
						* consultaOcupacioUseCaseController
								.getNombEspectadors(),
				ShowsCom.getInstance().getCanvis());

		// TODO duda preuTotal
		this.preuTotal = dadesEntrada.getPreu();

		return dadesEntrada;
	}

	public float obtePreuMoneda(final String moneda) throws ServeiNoDisponible {
		AdapterFactory adapterFactory = AdapterFactory.getInstance();
		IConversorAdapter conversorAdapter = adapterFactory
				.getConversorAdapter();

		Moneda divisa = ShowsCom.getInstance().getDivisa();

		double rate = conversorAdapter.convert(divisa, Moneda.valueOf(moneda));

		// TODO duda preuTotal, guardar en controlador? :S
		this.preuTotal = (float) (this.preuTotal * rate);
		return this.preuTotal;
	}

	public void pagament(final String dni, final int codiB,
			final String numCompte) throws PagamentNoAutoritzat {
		IPagamentAdapter pagamentAdapter = AdapterFactory.getInstance()
				.getPagamentAdapter();

		int codiBancShows = ShowsCom.getInstance().getCodiBanc();
		String numcompteShows = ShowsCom.getInstance().getNumeroCompte();

		pagamentAdapter.autoritza(dni, codiB, numCompte, this.preuTotal,
				codiBancShows, numcompteShows);

		IControllerRepresentacio controllerRepresentacio = ControllerDataFactory
				.getInstance().getControllerRepresentacio();

		Representacio representacio = controllerRepresentacio.getRepresentacio(
				consultaOcupacioUseCaseController.getNomLocal(),
				consultaOcupacioUseCaseController.getSessio(),
				consultaRepresentacioUseCaseController.getData());

		Entrada entrada = representacio.createEntrada(
				consultaRepresentacioUseCaseController.getTitol(), dni,
				consultaOcupacioUseCaseController.getNombEspectadors(),
				consultaRepresentacioUseCaseController.getData(),
				this.preuTotal);

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		session.saveOrUpdate(entrada);
		session.getTransaction().commit();
	}
}
