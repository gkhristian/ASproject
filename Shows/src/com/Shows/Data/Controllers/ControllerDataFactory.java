package com.Shows.Data.Controllers;

import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;

public class ControllerDataFactory {

	private static ControllerDataFactory instance;

	private IControllerRepresentacio controllerRepresentacio;
	private IControllerEspectacle controllerEspectacle;

	public static ControllerDataFactory getInstance() {
		if (instance == null)
			instance = new ControllerDataFactory();
		return instance;
	}

	public IControllerRepresentacio getControllerRepresentacio() {
		if (controllerRepresentacio == null)
			controllerRepresentacio = new ControllerRepresentacio();
		return controllerRepresentacio;
	}

	public IControllerEspectacle getControllerEspectacle() {
		if (controllerEspectacle == null)
			controllerEspectacle = new ControllerEspectacle();
		return controllerEspectacle;
	}
}
