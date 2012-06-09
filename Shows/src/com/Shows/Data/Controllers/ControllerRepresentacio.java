package com.Shows.Data.Controllers;

import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Model.Representacio;

public class ControllerRepresentacio implements IControllerRepresentacio {

	public Representacio getRepresentacio(String nomLocal, String sessio) {
		return new Representacio();
	}
}
