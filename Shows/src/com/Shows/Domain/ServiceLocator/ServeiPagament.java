package com.Shows.Domain.ServiceLocator;

import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;

public class ServeiPagament extends Servei {

	public boolean autoritza(String dni, int codiB, String numCompte,
			float importe, int codiBancShows, String numcompteShows) {
		double random = Math.random();
		boolean autoritza = true;
		if (random > 0.95)
			autoritza = false;
		return autoritza;
	}
}
