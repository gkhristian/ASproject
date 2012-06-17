package com.Shows.Data.Controllers;

import java.util.List;

import org.hibernate.Session;

import com.Shows.Data.DataMapper.HibernateUtil;
import com.Shows.Data.Interfaces.IControllerEspectacle;
import com.Shows.Domain.Model.Espectacle;

public class ControllerEspectacle implements IControllerEspectacle {

	@SuppressWarnings("unchecked")
	@Override
	public List<Espectacle> allEspectacles() {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		return (List<Espectacle>) session.createQuery("from Espectacle").list();
	}

	@Override
	public Espectacle getEspectacle(String titol) {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		return (Espectacle) session.get(Espectacle.class, titol);
	}
}
