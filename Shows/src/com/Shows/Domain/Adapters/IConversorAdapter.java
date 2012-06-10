package com.Shows.Domain.Adapters;

import com.Shows.Domain.Model.Moneda;


public interface IConversorAdapter {    
	
	public double convert(Moneda divisa, Moneda moneda);
}
