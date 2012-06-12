package com.Shows.Presentation.Controller;

import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.Domain.Exception.noHiHaRepresentacions;
import com.Shows.Domain.Exception.seientsNoDisp;
import com.Shows.Domain.Model.Moneda;
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
			throws noHiHaRepresentacions {
		comprarEntradaView
				.mostraRepresentacions(comprarEntradaUseCaseController
						.obteRepresentacions(titol, data));
	}

	public void PrOkObteOcupacio(String nomLocal, TipusSessio sessio,
			int nombEspectadors) throws seientsNoDisp {
		comprarEntradaView.mostraOcupacio(comprarEntradaUseCaseController
				.obteOcupacio(nomLocal, sessio, nombEspectadors));// , data));
	}

	public void PrOkSelecionarSeients(Set<PosicioSeient> seients) {

	}

	public void PrOkPagament(String dni, int codiB, String numCompte) {
	}

	public void PrCancellar() {
		comprarEntradaView.mostraAvis("");
	}

	public void PrCancellarAvis() {

	}

	public void PrFi() {
		comprarEntradaView.tancar();
	}

	public void canviPreuMoneda(Moneda moneda) {
		// TODO esto esta bien???
		// Falta llamada en ComprarEntradaView???
	}
}
