package com.Shows.Domain.Adapters;

import java.util.Date;

import com.Shows.Domain.ServiceLocator.ServeiPagament;
import com.Shows.Domain.ServiceLocator.ServiceLocator;

public class PagamentAdapter implements IPagamentAdapter {

    @Override
    public boolean autoritza(String numTarj, Date dCad, float preuTotal) {
        
        ServeiPagament sp = ServiceLocator.getInstance().find("Servei Pagament");
        return sp.autoritza(numTarj, dCad, preuTotal);
    }
}
