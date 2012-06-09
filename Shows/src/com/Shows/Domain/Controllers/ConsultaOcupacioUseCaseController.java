package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.TupleTypes.PosicioSeient;

public class ConsultaOcupacioUseCaseController {
	// TODO Replicado ====//
	private String nomLocal;
	private String sessio;
	private int nombEspectadors;

	// ===================//

	public Set<PosicioSeient> obteOcupacio(String nomLocal, String sessio,
			int nombEspectadors, Date data) {
		this.nomLocal = nomLocal;
		this.sessio = sessio;
		this.nombEspectadors = nombEspectadors;
		return new HashSet<PosicioSeient>();
	}
}
