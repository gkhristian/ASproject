package com.Shows.Domain.ServiceLocator;

import java.util.Date;

public class ServeiPagament extends Servei {

    public boolean autoritza(String dni, int codiB, String numCompte, float importe, int codiBancShows, String numcompteShows) {
        return true;
    }
}
