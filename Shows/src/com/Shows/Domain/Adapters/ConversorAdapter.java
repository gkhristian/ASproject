package com.Shows.Domain.Adapters;

import com.Shows.Domain.Exceptions.ServeiNoDisponible;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.ServiceLocator.CurrencyConvertor;

public class ConversorAdapter implements IConversorAdapter {

	@Override
	public double convert(Moneda divisa, Moneda moneda)
			throws ServeiNoDisponible {
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		try {
			return currencyConvertor.convert(divisa, moneda);
		} catch (java.lang.Exception ex) {
			throw new ServeiNoDisponible("El servei no està disponible");
		}

	}
}
