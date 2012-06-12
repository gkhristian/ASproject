package com.Shows.Domain.Adapters;

import com.Shows.Domain.Exceptions.PagamentNoAutoritzat;

public interface IPagamentAdapter {

	public boolean autoritza(String dni, int codiB, String numCompte,
			float importe, int codiBancShows, String numcompteShows)
			throws PagamentNoAutoritzat;
}
