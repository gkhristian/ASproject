package com.Shows.Presentation.Controller;

import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
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

	public void PrOkObteRepresentacions(String titol, Date data)
			throws NoHiHaRepresentacions {
		comprarEntradaView
				.mostraRepresentacions(comprarEntradaUseCaseController
						.obteRepresentacions(titol, data));
	}

	public void PrOkObteOcupacio(String nomLocal, TipusSessio sessio,
			int nombEspectadors) throws SeientsNoDisp {
		comprarEntradaView.mostraOcupacio(comprarEntradaUseCaseController
				.obteOcupacio(nomLocal, sessio, nombEspectadors));// , data));
	}

	public void PrOkSelecionarSeients(Set<PosicioSeient> seients) {
		comprarEntradaView.mostraPreu(comprarEntradaUseCaseController
				.selecionarSeients(seients));
	}

	public void PrOkPagament(String dni, int codiB, String numCompte)
			throws PagamentNoAutoritzat {
		// TODO Data del controlador?
		comprarEntradaUseCaseController.pagament(dni, codiB, numCompte,
				comprarEntradaUseCaseController.getData());
		comprarEntradaView.mostraAvisFi("Tot ha finalitzat correctament");
	}

	public void PrCancellar() {
		// TODO aviso aquí?
		comprarEntradaView.mostraAvis("");
	}

	public void PrCancellarAvis() {

	}

	public void PrFi() {
		comprarEntradaView.tancar();
	}

	public void canviPreuMoneda(String moneda) throws ServeiNoDisponible {
		comprarEntradaView.mostraPreuMoneda(comprarEntradaUseCaseController.obtePreuMoneda(moneda));
	}
}
