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
	// TODO Replicado ====//
	private String titol;
	private Date data;
	// ===================//
	// TODO Replicado ====//
	private String nomLocal;
	private TipusSessio sessio;
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

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data)
			throws NoHiHaRepresentacions {
		// Replicado...
		this.titol = titol;
		this.data = data;
		consultaRepresentacioUseCaseController = new ConsultaRepresentacioUseCaseController();
		return consultaRepresentacioUseCaseController.obteRepresentacions(
				titol, data);
	}

	public Set<PosicioSeient> obteOcupacio(String nomLocal, TipusSessio sessio,
			int nombEspectadors) throws SeientsNoDisp {// , Date data) {
		// Replicado...
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;
		// this.data = data; // TODO Es necesario???

		consultaOcupacioUseCaseController = new ConsultaOcupacioUseCaseController();

		return consultaOcupacioUseCaseController.obteOcupacio(nomLocal, sessio,
				nombEspectadors);// , data);
	}

	public DadesEntrada selecionarSeients(Set<PosicioSeient> seients) {
		this.seients = seients;

		IControllerRepresentacio controllerRepresentacio = controllerDataFactory
				.getControllerRepresentacio();
		Representacio representacio = controllerRepresentacio.getRepresentacio(
				nomLocal, sessio);
		DadesEntrada dadesEntrada = representacio.obtePreu(nombEspectadors);

		// TODO duda preuTotal
		this.preuTotal = dadesEntrada.getPreu();
		
		return dadesEntrada;
	}

	public float obtePreuMoneda(String moneda) throws ServeiNoDisponible {
		AdapterFactory adapterFactory = AdapterFactory.getInstance();
		IConversorAdapter conversorAdapter = adapterFactory
				.getConversorAdapter();

		Moneda divisa = ShowsCom.getInstance().getDivisa();
		
		
		double rate = conversorAdapter.convert(divisa, Moneda.valueOf(moneda));

		// TODO duda preuTotal, guardar en controlador? :S
		this.preuTotal = (float) (preuTotal * rate);
		return this.preuTotal;
	}

	public void pagament(String dni, int codiB, String numCompte, Date data)
			throws PagamentNoAutoritzat {
		IPagamentAdapter pagamentAdapter = AdapterFactory.getInstance()
				.getPagamentAdapter();

		int codiBancShows = ShowsCom.getInstance().getCodiBanc();
		String numcompteShows = ShowsCom.getInstance().getNumeroCompte();

		pagamentAdapter.autoritza(dni, codiB, numCompte, preuTotal,
				codiBancShows, numcompteShows);
		IControllerRepresentacio controllerRepresentacio = ControllerDataFactory
				.getInstance().getControllerRepresentacio();

		Representacio representacio = controllerRepresentacio.getRepresentacio(
				nomLocal, sessio);
		Entrada entrada = representacio.createEntrada(titol, dni,
				nombEspectadors, data, preuTotal);

		Session session = HibernateUtil.getSession();

		session.beginTransaction();
		session.saveOrUpdate(entrada);
		session.getTransaction().commit();
	}

	public Date getData() {
		return data;
	}
}
