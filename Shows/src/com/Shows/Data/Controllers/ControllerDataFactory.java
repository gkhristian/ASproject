package com.Shows.Data.Controllers;

import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Data.Interfaces.IControllerSeientsEnRepresentacio;

public class ControllerDataFactory {

	private static ControllerDataFactory instance;

	private IControllerRepresentacio controllerRepresentacio;
	private IControllerEspectacle controllerEspectacle;
	private IControllerSeientsEnRepresentacio controllerSeientsEnRepresentacio;

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

	public IControllerSeientsEnRepresentacio getControllerSeientsEnRepresentacio() {
		if (controllerSeientsEnRepresentacio == null)
			controllerSeientsEnRepresentacio = new ControllerSeientsEnRepresentacio();
		return controllerSeientsEnRepresentacio;
	}
}
