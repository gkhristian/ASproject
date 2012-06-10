package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Model.Representacio;
import com.Shows.TupleTypes.PosicioSeient;

public class ConsultaOcupacioUseCaseController {
	// TODO Replicado ====//
	private String nomLocal;
	private String sessio;
	private int nombEspectadors;

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	// ===================//

	public Set<PosicioSeient> obteOcupacio(String nomLocal, String sessio,
			int nombEspectadors) { // , Date data) {
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;

		IControllerRepresentacio controllerRepresentacio = controllerDataFactory
				.getControllerRepresentacio();
		Representacio representacio = controllerRepresentacio.getRepresentacio(
				nomLocal, sessio);

		// TODO representacio.obteLliures(nombEspectadors);

		return new HashSet<PosicioSeient>();
	}
}
