package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Exceptions.SeientsNoDisp;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.TipusSessio;
import com.Shows.TupleTypes.PosicioSeient;

public class ConsultaOcupacioUseCaseController {
	private String nomLocal;
	private TipusSessio sessio;
	private int nombEspectadors;

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	public Set<PosicioSeient> obteOcupacio(final String nomLocal,
			final TipusSessio sessio, final int nombEspectadors, Date data)
			throws SeientsNoDisp {
		
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;

		IControllerRepresentacio controllerRepresentacio = controllerDataFactory
				.getControllerRepresentacio();
		Representacio representacio = controllerRepresentacio.getRepresentacio(
				nomLocal, sessio, data);

		return representacio.obteLliures(nombEspectadors);
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public TipusSessio getSessio() {
		return sessio;
	}

	public int getNombEspectadors() {
		return nombEspectadors;
	}
}
