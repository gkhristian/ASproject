package com.Shows.Presentation.Controller;

import java.awt.Color;
import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.Domain.Controllers.ConsultaOcupacioUseCaseController;
import com.Shows.Domain.Controllers.ConsultaRepresentacionsUseCaseController;
import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Exceptions.SeientsNoOk;
import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.Presentation.View.IniciView;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaController {

	private ComprarEntradaUseCaseController comprarEntradaUseCaseController;
	private ConsultaOcupacioUseCaseController consultaOcupacioUseCaseController;
	private ConsultaRepresentacionsUseCaseController consultaRepresentacionsUseCaseController;
	private IniciView iniciView;

	private Color backgroundColor;

	public ComprarEntradaController() {

		backgroundColor = new Color(250, 250, 250);

		comprarEntradaUseCaseController = new ComprarEntradaUseCaseController();

		iniciView = new IniciView(this);
	}

	public void PrComprarEntrada() {

		comprarEntradaUseCaseController.init();
		iniciView.mostraEspectacles(comprarEntradaUseCaseController
				.obteEspectacles());
	}

	public void PrConsultaOcupacio(final String nomLocal,
			final TipusSessio sessio, final int nombEspectadors, final Date data)
			throws SeientsNoDisp {

		// consultaOcupacioUseCaseController.init();
		iniciView.mostraOcupacio(consultaOcupacioUseCaseController
				.obteOcupacio(nomLocal, sessio, nombEspectadors, data));
	}

	public void PrConsultaRepresentacio(final String titol, final Date data)
			throws NoHiHaRepresentacions {

		// consultaRepresentacionsUseCaseController.init();
		iniciView
				.mostraRepresentacions(consultaRepresentacionsUseCaseController
						.obteRepresentacions(titol, data));
	}

	public void PrOkObteRepresentacions(final String titol, final Date data)
			throws NoHiHaRepresentacions {

		iniciView.mostraRepresentacions(comprarEntradaUseCaseController
				.obteRepresentacions(titol, data));
	}

	public void PrOkObteOcupacio(final String nomLocal,
			final TipusSessio sessio, final int nombEspectadors)
			throws SeientsNoDisp {

		iniciView.mostraOcupacio(comprarEntradaUseCaseController.obteOcupacio(
				nomLocal, sessio, nombEspectadors));
	}

	public void PrOkSelecionarSeients(final Set<PosicioSeient> seients)
			throws SeientsNoOk {

		iniciView.mostraPreu(comprarEntradaUseCaseController
				.selecionarSeients(seients));
	}

	public void PrOkPagament(final String dni, final int codiB,
			final String numCompte) throws PagamentNoAutoritzat {

		comprarEntradaUseCaseController.pagament(dni, codiB, numCompte);
		iniciView.mostraAvisFi("Tot ha finalitzat correctament");
	}

	public void PrCancellar() {

		iniciView
				.mostraAvis("Si cancel\u00B7la l'operaci\u00F3 es perdr\u00E0 tot el proc\u00E8s");
	}

	public void PrFi() {

		iniciView.tancar();
	}

	public void canviPreuMoneda(final String moneda) throws ServeiNoDisponible {

		iniciView.mostraPreuMoneda(comprarEntradaUseCaseController
				.obtePreuMoneda(moneda));
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}
}
