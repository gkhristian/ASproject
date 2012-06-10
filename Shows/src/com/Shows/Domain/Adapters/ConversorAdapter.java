package com.Shows.Domain.Adapters;

import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.ServiceLocator.CurrencyConvertor;

public class ConversorAdapter implements IConversorAdapter {

	@Override
	public double convert(Moneda divisa, Moneda moneda) {
		CurrencyConvertor cc = new CurrencyConvertor();
		return cc.convert(divisa, moneda);
	}
}
