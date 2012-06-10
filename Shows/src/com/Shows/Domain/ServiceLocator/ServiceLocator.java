package com.Shows.Domain.ServiceLocator;

public class ServiceLocator {

	private static ServiceLocator instance;
	private ServeiPagament serveiPagament;
	private CurrencyConvertor serveiConvert;

	private ServiceLocator() {
	}

	public static ServiceLocator getInstance() {

		if (instance == null)
			instance = new ServiceLocator();
		return instance;
	}

	public Servei find(String name) {
		if (name.equals("Servei Pagament")) {
			if (serveiPagament == null)
				serveiPagament = new ServeiPagament();
			return serveiPagament;
		} else {
			if (serveiConvert == null)
				serveiConvert = new CurrencyConvertor();
			return serveiConvert;
		}
	}
}
