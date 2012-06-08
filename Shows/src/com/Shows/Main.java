package com.Shows;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.Shows.Domain.Model.Local;
import com.Shows.Domain.Model.Seient;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Seient seient = new Seient();
		seient.setFila(1);
		seient.setColumna(1);

		Set<Seient> seients = new HashSet<Seient>();
		seients.add(seient);

		Local local = new Local(seients);
		local.setNom("Prueba");
		local.setAdreca("C/Prueba");

		session.save(seient);

		session.save(local);

		session.getTransaction().commit();
	}
}
