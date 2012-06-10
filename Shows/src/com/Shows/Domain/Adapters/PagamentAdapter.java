package com.Shows.Domain.Adapters;

import java.util.Date;

import com.Shows.Domain.ServiceLocator.ServeiPagament;
import com.Shows.Domain.ServiceLocator.ServiceLocator;

public class PagamentAdapter implements IPagamentAdapter {

    @Override
    public boolean autoritza(String dni, int codiB, String numCompte, float importe, int codiBancShows, String numcompteShows) {
        ServeiPagament sp = (ServeiPagament) ServiceLocator.getInstance().find("Servei Pagament");
        return sp.autoritza( dni, codiB, numCompte, importe, codiBancShows, numcompteShows);
    }
}
