package com.Shows.Data.Interfaces;

import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.TipusSessio;

public interface IControllerRepresentacio {

	public Representacio getRepresentacio(String nomLocal, TipusSessio sessio);
}
