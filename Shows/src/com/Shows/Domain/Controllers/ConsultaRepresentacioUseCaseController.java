package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.Set;

import com.Shows.Data.Controllers.ControllerDataFactory;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Domain.Exceptions.NoHiHaRepresentacions;
import com.Shows.TupleTypes.DadesRepresentacio;

public class ConsultaRepresentacioUseCaseController {
	private String titol;
	private Date data;

	private ControllerDataFactory controllerDataFactory = ControllerDataFactory
			.getInstance();

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data)
			throws NoHiHaRepresentacions {
		this.setTitol(titol);
		this.setData(data);

		IControllerEspectacle controllerEspectacle = controllerDataFactory
				.getControllerEspectacle();

		return controllerEspectacle.getEspectacle(titol).obteRep(data);
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
