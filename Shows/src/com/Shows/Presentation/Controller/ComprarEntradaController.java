package com.Shows.Presentation.Controller;

import java.sql.Date;
import java.util.Set;

import com.Shows.Domain.Controllers.ComprarEntradaUseCaseController;
import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaController {
	private ComprarEntradaUseCaseController comprarEntradaUseCaseController;

	public ComprarEntradaController() {
		comprarEntradaUseCaseController = new ComprarEntradaUseCaseController();
	}
	
	public void PrOkObteRepresentacions(String titol, Date data) {
	}

	public void PrOkObteOcupacio(String numLocal, String sessio, int nombEspectadors) {
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
	
	public void canviPreuMoneda(String moneda) {
		//TODO esto esta bien???
	}
}
