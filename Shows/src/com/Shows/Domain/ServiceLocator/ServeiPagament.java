package com.Shows.Domain.ServiceLocator;

public class ServeiPagament extends Servei {

	public boolean autoritza(String dni, int codiB, String numCompte,
			float importe, int codiBancShows, String numcompteShows) {
		int random = (int) Math.random();
		boolean autoritza = true;
		if (random % 9 == 0)
			autoritza = false;
		return autoritza;
	}
}
