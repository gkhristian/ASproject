package com.Shows.Data.Controllers;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.Shows.Data.DataMapper.HibernateUtil;
import com.Shows.Data.Interfaces.IControllerSeientsEnRepresentacio;
import com.Shows.Domain.Model.AuxiliarRepresentacio;
import com.Shows.Domain.Model.AuxiliarSeient;
import com.Shows.Domain.Model.AuxiliarSeientEnRepresentacio;
import com.Shows.Domain.Model.Local;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.Seient;
import com.Shows.Domain.Model.SeientEnRepresentacio;
import com.Shows.Domain.Model.Sessio;
import com.Shows.Domain.Model.TipusSessio;

public class ControllerSeientsEnRepresentacio implements
		IControllerSeientsEnRepresentacio {

	@SuppressWarnings("unchecked")
	@Override
	public List<SeientEnRepresentacio> allSeientsEnRepresentacio() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		return (List<SeientEnRepresentacio>) session.createQuery(
				"from SeientEnRepresentacio").list();

	}

	@Override
	public SeientEnRepresentacio getSeientEnRepresentacio(String nomLocal,
			int fila, int columna, Date data, TipusSessio sessio) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Sessio sesion =  (Sessio) session.get(Sessio.class, sessio);
		Local local = (Local) session.get(Local.class, nomLocal);
		Representacio representacio = (Representacio) session.get(Representacio.class, new AuxiliarRepresentacio(sesion, local, data));
		
		Seient seient = (Seient) session.get(Seient.class, new AuxiliarSeient(local,fila,columna));
		
		return (SeientEnRepresentacio) session.get(SeientEnRepresentacio.class, new AuxiliarSeientEnRepresentacio(seient, representacio));

	}

}
