package com.Shows.Domain.Adapters;

import com.Shows.Domain.Model.Moneda;
import com.Shows.Exceptions.ServeiNoDisponible;

public interface IConversorAdapter {

	public double convert(Moneda divisa, Moneda moneda)
			throws ServeiNoDisponible;
}
