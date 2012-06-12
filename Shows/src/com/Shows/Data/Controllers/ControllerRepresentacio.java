package com.Shows.Data.Controllers;

import org.hibernate.Session;

import com.Shows.HibernateUtil;
import com.Shows.Data.Interfaces.IControllerRepresentacio;
import com.Shows.Domain.Model.AuxiliarRepresentacio;
import com.Shows.Domain.Model.Local;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.Sessio;
import com.Shows.Domain.Model.TipusSessio;

public class ControllerRepresentacio implements IControllerRepresentacio {

	@Override
	public Representacio getRepresentacio(String nomLocal, TipusSessio sessio) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Local local = (Local) session.get(Local.class, nomLocal);
		Sessio oSessio = (Sessio) session.get(Sessio.class, sessio);

		return (Representacio) session.get(Representacio.class,
				new AuxiliarRepresentacio(oSessio, local));
	}
}
