package com.Shows.Data.Interfaces;

import java.sql.Date;
import java.util.List;

import com.Shows.Domain.Model.SeientEnRepresentacio;
import com.Shows.Domain.Model.TipusSessio;

public interface IControllerSeientsEnRepresentacio {
	public List<SeientEnRepresentacio> allSeientsEnRepresentacio();

	public SeientEnRepresentacio getSeientEnRepresentacio(String nomLocal,
			int fila, int columna, Date data, TipusSessio sessio);
}
