package com.Shows.Domain.ServiceLocator;

import net.webservicex.CurrencyConvertorSoap_CurrencyConvertorSoap_Client;

import com.Shows.Domain.Model.Moneda;

public class CurrencyConvertor extends Servei {

	public double convert(Moneda divisa, Moneda moneda) {
		double res = CurrencyConvertorSoap_CurrencyConvertorSoap_Client
				.convert(divisa, moneda);
		return res;
	}
}