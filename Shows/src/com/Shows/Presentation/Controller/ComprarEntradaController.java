package com.Shows.Presentation.Controller;

import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Exceptions.SeientsNoOk;
import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.Presentation.View.ComprarEntradaView;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaController {
	private ComprarEntradaUseCaseController comprarEntradaUseCaseController;
	private ComprarEntradaView comprarEntradaView;

	public ComprarEntradaController() {

		comprarEntradaUseCaseController = new ComprarEntradaUseCaseController();

		comprarEntradaView = new ComprarEntradaView(this);
	}

	public void PrComprarEntrada() {

		comprarEntradaView.mostraEspectacles(comprarEntradaUseCaseController
				.obteEspectacles());
	}

	public void PrOkObteRepresentacions(final String titol, final Date data)
			throws NoHiHaRepresentacions {

		comprarEntradaView
				.mostraRepresentacions(comprarEntradaUseCaseController
						.obteRepresentacions(titol, data));
	}

	public void PrOkObteOcupacio(final String nomLocal,
			final TipusSessio sessio, final int nombEspectadors)
			throws SeientsNoDisp {

		comprarEntradaView.mostraOcupacio(comprarEntradaUseCaseController
				.obteOcupacio(nomLocal, sessio, nombEspectadors));
	}

	public void PrOkSelecionarSeients(final Set<PosicioSeient> seients)
			throws SeientsNoOk {

		comprarEntradaView.mostraPreu(comprarEntradaUseCaseController
				.selecionarSeients(seients));
	}

	public void PrOkPagament(final String dni, final int codiB,
			final String numCompte) throws PagamentNoAutoritzat {

		comprarEntradaUseCaseController.pagament(dni, codiB, numCompte);
		comprarEntradaView.mostraAvisFi("Tot ha finalitzat correctament");
	}

	public void PrCancellar() {

		comprarEntradaView
				.mostraAvis("Si cancel\u00B7la l'operaci\u00F3 es perdr\u00E0 tot el proc\u00E8s");
	}

	public void PrFi() {

		comprarEntradaView.tancar();
	}

	public void canviPreuMoneda(final String moneda) throws ServeiNoDisponible {

		comprarEntradaView.mostraPreuMoneda(comprarEntradaUseCaseController
				.obtePreuMoneda(moneda));
	}
}
