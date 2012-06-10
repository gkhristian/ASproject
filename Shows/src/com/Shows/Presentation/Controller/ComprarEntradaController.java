package com.Shows.Presentation.Controller;

import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Presentation.ComprarEntradaView;
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

	public void PrOkObteRepresentacions(String titol, Date data) {
		comprarEntradaView
				.mostraRepresentacions(comprarEntradaUseCaseController
						.obteRepresentacions(titol, data));
	}

	public void PrOkObteOcupacio(String numLocal, String sessio,
			int nombEspectadors) {
	}

	public void PrOkSelecionarSeients(Set<PosicioSeient> seients) {
	}

	public void PrOkPagament(String dni, int codiB, String numCompte) {
	}

	public void PrCancellar() {
	}

	public void PrCancellarAvis() {
	}

	public void PrFi() {

	}

	public void canviPreuMoneda(Moneda moneda) {
		// TODO esto esta bien???
	}
}
