package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Domain.Exception.noHiHaRepresentacions;
import com.Shows.TupleTypes.DadesRepresentacio;

public class ConsultaRepresentacioUseCaseController {
	// TODO Replicado ====//
	private String titol;
	private Date data;
	// ===================//

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data)
			throws noHiHaRepresentacions {
		this.titol = titol;
		this.data = data;

		IControllerEspectacle controllerEspectacle = controllerDataFactory
				.getControllerEspectacle();

		return controllerEspectacle.getEspectacle(titol).obteRep(data);
	}
}
