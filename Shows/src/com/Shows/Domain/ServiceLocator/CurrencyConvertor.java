package com.Shows.Domain.ServiceLocator;

import net.webservicex.CurrencyConvertorSoap_CurrencyConvertorSoap_Client;

import com.Shows.Domain.Model.Moneda;
import com.Shows.Exceptions.ServeiNoDisponible;

public class CurrencyConvertor extends Servei {

	public double convert(Moneda divisa, Moneda moneda)
			throws ServeiNoDisponible {

		return CurrencyConvertorSoap_CurrencyConvertorSoap_Client.convert(
				divisa, moneda);
	}
}