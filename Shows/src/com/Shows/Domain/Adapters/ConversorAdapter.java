package com.Shows.Domain.Adapters;

import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.ServiceLocator.CurrencyConvertor;
import com.Shows.Domain.ServiceLocator.ServeiPagament;
import com.Shows.Domain.ServiceLocator.ServiceLocator;

public class ConversorAdapter implements IConversorAdapter {

    @Override
	public float convert(Moneda divisa, Moneda moneda){
        CurrencyConvertor cc = (CurrencyConvertor) ServiceLocator.getInstance().find("currencyConvertor");
        return cc.convert(divisa, moneda);
    }

}
