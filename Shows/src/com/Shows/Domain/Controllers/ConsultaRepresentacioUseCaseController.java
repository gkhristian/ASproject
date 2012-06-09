package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.TupleTypes.DadesRepresentacio;

public class ConsultaRepresentacioUseCaseController {
	// TODO Replicado ====//
	private String titol;
	private Date data;
	// ===================//

	public Set<DadesRepresentacio> obteRepresentacions(String titol, Date data) {
		this.titol = titol;
		this.data = data;
		return new HashSet<DadesRepresentacio>();
	}
}
