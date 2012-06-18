package com.Shows.Domain.Adapters;

import com.Shows.Domain.ServiceLocator.ServeiPagament;
import com.Shows.Domain.ServiceLocator.ServiceLocator;
import com.Shows.Exceptions.PagamentNoAutoritzat;

public class PagamentAdapter implements IPagamentAdapter {

	@Override
	public boolean autoritza(String dni, int codiB, String numCompte,
			float importe, int codiBancShows, String numcompteShows)
			throws PagamentNoAutoritzat {

		ServeiPagament serveiPagament = (ServeiPagament) ServiceLocator
				.getInstance().find("Servei Pagament");

		boolean autoritza = serveiPagament.autoritza(dni, codiB, numCompte,
				importe, codiBancShows, numcompteShows);

		if (!autoritza) {
			throw new PagamentNoAutoritzat("Pagament no autoritzat");
		} else
			return true;
	}
}
