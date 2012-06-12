package com.Shows.Domain.Controllers;

import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.TupleTypes.PosicioSeient;

public class ConsultaOcupacioUseCaseController {
	// TODO Replicado ====//
	private String nomLocal;
	private TipusSessio sessio;
	private int nombEspectadors;

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	// ===================//

	public Set<PosicioSeient> obteOcupacio(String nomLocal, TipusSessio sessio,
			int nombEspectadors) throws SeientsNoDisp { // , Date data) {
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;

		IControllerRepresentacio controllerRepresentacio = controllerDataFactory
				.getControllerRepresentacio();
		Representacio representacio = controllerRepresentacio.getRepresentacio(
				nomLocal, sessio);

		return representacio.obteLliures(nombEspectadors);
	}
}
