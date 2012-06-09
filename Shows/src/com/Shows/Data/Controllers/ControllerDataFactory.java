package com.Shows.Data.Controllers;

import com.Shows.Data.Interfaces.IControllerRepresentacio;

public class ControllerDataFactory {

	private static ControllerDataFactory instance;
	
	private IControllerRepresentacio controllerRepresentacio;

	public static ControllerDataFactory getInstance() {
		if (instance == null)
			instance = new ControllerDataFactory();
		return instance;
	}

	public IControllerRepresentacio getControllerRepresentacio() {
		return controllerRepresentacio;
	}
}
