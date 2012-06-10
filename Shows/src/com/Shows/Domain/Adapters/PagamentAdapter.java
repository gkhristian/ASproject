package com.Shows.Domain.Adapters;

import java.rmi.RemoteException;

import com.Shows.Domain.ServiceLocator.ServeiPagament;
import com.Shows.Domain.ServiceLocator.ServiceLocator;

public class PagamentAdapter implements IPagamentAdapter {

	@Override
	public boolean autoritza(String dni, int codiB, String numCompte,
			float importe, int codiBancShows, String numcompteShows)
			throws Exception {
		ServeiPagament sp = (ServeiPagament) ServiceLocator.getInstance().find(
				"Servei Pagament");
		boolean autoritza = sp.autoritza(dni, codiB, numCompte, importe,
				codiBancShows, numcompteShows);
		if (!autoritza) {
			throw new RemoteException();
		} else
			return true;
	}
}
