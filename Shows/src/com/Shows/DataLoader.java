package com.Shows;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Shows.Domain.Model.Entrada;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Estat;
import com.Shows.Domain.Model.Estrena;
import com.Shows.Domain.Model.Local;
import com.Shows.Domain.Model.Moneda;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.Seient;
import com.Shows.Domain.Model.SeientEnRepresentacio;
import com.Shows.Domain.Model.Sessio;
import com.Shows.Domain.Model.SetMoneda;
import com.Shows.Domain.Model.ShowsCom;
import com.Shows.Domain.Model.TipusSessio;

public class DataLoader {
	public static void initDatabase() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		/* Locals */
		Local local1 = new Local("Palau Sant Jordi", "C/Falsa 123");
		Local local2 = new Local("A Tomar Por Culo", "C/Parla");
		session.save(local1);
		session.save(local2);

		/* Seients */
		int filas1 = 5;
		int columnas1 = 5;
		int filas2 = 3;
		int columnas2 = 5;

		HashSet<Seient> seients1 = new HashSet<Seient>();
		HashSet<Seient> seients2 = new HashSet<Seient>();

		for (int i = 0; i < filas1; ++i) {
			for (int j = 0; j < columnas1; j++) {
				Seient aux = new Seient(local1, i + 1, j + 1);
				session.save(aux);
				seients1.add(aux);
			}
		}

		for (int i = 0; i < filas2; ++i) {
			for (int j = 0; j < columnas2; j++) {
				Seient aux = new Seient(local2, i + 1, j + 1);
				session.save(aux);
				seients2.add(aux);
			}
		}

		local1.setSeients(seients1);
		local2.setSeients(seients2);

		/* Sessions */
		Sessio ses1 = new Sessio(TipusSessio.tarda);
		Sessio ses2 = new Sessio(TipusSessio.nit);
		session.save(ses1);
		session.save(ses2);

		/* Data */
		Date data1 = Date.valueOf("2012-06-30");
		Date data2 = Date.valueOf("2012-07-31");

		/* Representacions i Estrenes */
		Float preu1 = 10f;
		Float preu2 = 20f;

		int lliures1 = filas1 * columnas1;
		int lliures2 = filas2 * columnas2;

		Representacio rep1 = new Representacio(ses1, local1, preu1, data1,
				lliures1);
		Estrena est1 = new Estrena(ses2, local2, preu2, data2, lliures2, 1);
		session.save(rep1);
		session.save(est1);

		HashSet<Representacio> representacions1 = new HashSet<Representacio>();
		representacions1.add(rep1);
		HashSet<Representacio> representacions2 = new HashSet<Representacio>();
		representacions2.add(est1);

		/* Seients en representacio */
		HashSet<SeientEnRepresentacio> ser1 = new HashSet<SeientEnRepresentacio>();
		HashSet<SeientEnRepresentacio> ser2 = new HashSet<SeientEnRepresentacio>();

		Iterator<Seient> i1 = seients1.iterator();
		Iterator<Seient> i2 = seients2.iterator();

		Random randomGenerator = new Random();
		while (i1.hasNext()) {
			int random = randomGenerator.nextInt(2);
			if (random == 0) {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						i1.next(), rep1, Estat.lliure);
				session.save(aux);
				ser1.add(aux);
			} else {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						i1.next(), rep1, Estat.ocupat);
				session.save(aux);
				ser1.add(aux);
				--lliures1;
			}
		}
		while (i2.hasNext()) {
			int random = randomGenerator.nextInt(2);
			if (random == 0) {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						i2.next(), est1, Estat.lliure);
				session.save(aux);
				ser2.add(aux);
			} else {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						i2.next(), est1, Estat.ocupat);
				session.save(aux);
				ser2.add(aux);
				--lliures2;
			}
		}
		rep1.setSeientsEnRepresentacio(ser1);
		rep1.setNombreSeientsLliures(lliures1);
		est1.setSeientsEnRepresentacio(ser2);
		est1.setNombreSeientsLliures(lliures2);

		/* Espectacle */
		Espectacle esp1 = new Espectacle("Espectacular", 3, representacions1);
		Espectacle esp2 = new Espectacle("EspectaCULO", 1, representacions2);
		session.save(esp1);
		session.save(esp2);

		/* Entradas */
		HashSet<Entrada> ent1 = new HashSet<Entrada>();
		HashSet<Entrada> ent2 = new HashSet<Entrada>();
		Entrada aux = new Entrada("1", "343434", 2, data1, preu1, rep1);
		session.save(aux);
		ent1.add(aux);
		aux = new Entrada("2", "343435", 2, data1, preu1, rep1);
		session.save(aux);
		ent1.add(aux);
		aux = new Entrada("3", "54545", 1, data2, preu2, est1);
		session.save(aux);
		ent2.add(aux);

		rep1.setEntradas(ent1);
		est1.setEntradas(ent2);

		/* Shows.com */
		SetMoneda sm = new SetMoneda(Moneda.GBP, Moneda.USD);
		ShowsCom showscom = new ShowsCom(1, 12121, "34343434", 20f, Moneda.EUR,
				sm);
		session.save(showscom);

		session.getTransaction().commit();

	}

	public static void clearDatabase() throws HibernateException {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query;
		query = session.createSQLQuery("DROP SCHEMA public CASCADE");
		query.executeUpdate();
		query = session.createSQLQuery("CREATE SCHEMA public");
		query.executeUpdate();

		session.getTransaction().commit();
	}
}
