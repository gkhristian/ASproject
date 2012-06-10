package com.Shows.Data.Interfaces;

import java.util.List;

import com.Shows.Domain.Model.Espectacle;

public interface IControllerEspectacle {

	public List<Espectacle> allEspectacles();

	public Espectacle getEspectacle(String titol);
}
