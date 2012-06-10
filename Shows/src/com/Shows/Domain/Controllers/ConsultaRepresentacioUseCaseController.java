package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Representacio;
import com.Shows.TupleTypes.DadesRepresentacio;

public class ConsultaRepresentacioUseCaseController {
	// TODO Replicado ====//
	private String titol;
	private Date data;
	// ===================//
	
	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data) {
		this.titol = titol;
		this.data = data;
		
		IControllerEspectacle controllerEspectacle = controllerDataFactory
				.getControllerEspectacle();
		Espectacle espectacle = controllerEspectacle.getEspectacle(titol);
		
		return new HashSet<DadesRepresentacio>(); // TODO espectacle.obteRep(data)
	}
}
