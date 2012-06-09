package com.Shows.Domain.Controllers;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.Shows.TupleTypes.PosicioSeient;

public class ComprarEntradaUseCaseController {
	private String titol;
	private Date data;
	private String nomLocal;
	private String sessio;
	private String nombEspectadors;
	private Set<PosicioSeient> seients;
	private int preuTotal;

	public Set<String> obteEspectacles() {
		//TODO
		return new HashSet<String>();
	}
}
