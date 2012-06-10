package com.Shows.Domain.Adapters;

public class AdapterFactory {

	private static AdapterFactory instance;

	private IConversorAdapter conversorAdapter;
	private IPagamentAdapter pagamentAdapter;

	public static AdapterFactory getInstance() {
		if (instance == null)
			instance = new AdapterFactory();
		return instance;
	}

	public IConversorAdapter getConversorAdapter() {
		if (conversorAdapter == null)
			conversorAdapter = new ConversorAdapter();
		return conversorAdapter;
	}

	public IPagamentAdapter getPagamentAdapter() {
		if (pagamentAdapter == null)
			pagamentAdapter = new PagamentAdapter();
		return pagamentAdapter;
	}
}
