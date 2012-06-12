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
		Local local2_2 = new Local("PepeStage", "C/Tio Pepe");
		Local local2_3 = new Local("Akihabara Playbox", "C/Japon 2222bis");
		session.save(local1);
		session.save(local2);
		session.save(local2_2);
		session.save(local2_3);

		/* Seients */
		int filas1 = 5;
		int columnas1 = 5;
		int filas2 = 3;
		int columnas2 = 4;
		int filas2_2 = 4;
		int columnas2_2 = 6;
		int filas2_3 = 2;
		int columnas2_3 = 6;

		HashSet<Seient> seients1 = new HashSet<Seient>();
		HashSet<Seient> seients2 = new HashSet<Seient>();
		HashSet<Seient> seients2_2 = new HashSet<Seient>();
		HashSet<Seient> seients2_3 = new HashSet<Seient>();

		for (int i = 0; i < filas1; ++i) {
			for (int j = 0; j < columnas1; j++) {
				Seient aux = new Seient(local1, j + 1, i + 1);
				session.save(aux);
				seients1.add(aux);
			}
		}

		for (int i = 0; i < filas2; ++i) {
			for (int j = 0; j < columnas2; j++) {
				Seient aux = new Seient(local2, j + 1, i + 1);
				session.save(aux);
				seients2.add(aux);
			}
		}
		for (int i = 0; i < filas2_2; ++i) {
			for (int j = 0; j < columnas2_2; j++) {
				Seient aux = new Seient(local2_2, j + 1, i + 1);
				session.save(aux);
				seients2_2.add(aux);
			}
		}
		for (int i = 0; i < filas2_3; ++i) {
			for (int j = 0; j < columnas2_3; j++) {
				Seient aux = new Seient(local2_3, j + 1, i + 1);
				session.save(aux);
				seients2_3.add(aux);
			}
		}

		local1.setSeients(seients1);
		local2.setSeients(seients2);
		local2_2.setSeients(seients2_2);
		local2_3.setSeients(seients2_3);

		/* Sessions */
		Sessio ses1 = new Sessio(TipusSessio.tarda);
		Sessio ses2 = new Sessio(TipusSessio.nit);
		Sessio ses3 = new Sessio(TipusSessio.mati);
		session.save(ses1);
		session.save(ses2);
		session.save(ses3);

		/* Data */
		Date data1 = Date.valueOf("2012-06-30");
		Date data2 = Date.valueOf("2012-07-31");

		/* Representacions i Estrenes */
		Float preu1 = 10f;
		Float preu2 = 20f;

		int lliures1 = filas1 * columnas1;
		int lliures2 = filas2 * columnas2;
		int lliures2_2_1 = filas2_2 * columnas2_2;
		int lliures2_2_2 = filas2_2 * columnas2_2;
		int lliures2_3 = filas2_3 * columnas2_3;

		Representacio rep1 = new Representacio(ses1, local1, preu1, data1,
				lliures1);
		Estrena est1 = new Estrena(ses2, local2, preu2, data2, lliures2, 1);
		Estrena est2 = new Estrena(ses1, local2_2, preu2, data2, lliures2_2_1,
				1);
		Estrena est3 = new Estrena(ses2, local2_3, preu2, data2, lliures2_3, 1);
		Estrena est4 = new Estrena(ses3, local2_2, preu2, data2, lliures2_2_2,
				1);
		session.save(rep1);
		session.save(est1);
		session.save(est2);
		session.save(est3);
		session.save(est4);

		HashSet<Representacio> representacions1 = new HashSet<Representacio>();
		representacions1.add(rep1);
		HashSet<Representacio> representacions2 = new HashSet<Representacio>();
		representacions2.add(est1);
		representacions2.add(est2);
		representacions2.add(est3);
		representacions2.add(est4);

		/* Seients en representacio */
		seientsEnRepresentacio(rep1, seients1, lliures1, session);
		seientsEnRepresentacio(est1, seients2, lliures2, session);
		seientsEnRepresentacio(est2, seients2_2, lliures2_2_1, session);
		seientsEnRepresentacio(est3, seients2_3, lliures2_3, session);
		seientsEnRepresentacio(est4, seients2_2, lliures2_2_2, session);

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

	private static void seientsEnRepresentacio(Representacio rep,
			HashSet<Seient> seients, int lliures, Session session) {
		Iterator<Seient> it = seients.iterator();
		int ll = lliures;
		Random randomGenerator = new Random();
		HashSet<SeientEnRepresentacio> ser = new HashSet<SeientEnRepresentacio>();
		while (it.hasNext()) {
			int random = randomGenerator.nextInt(2);
			if (random == 0) {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						it.next(), rep, Estat.lliure);
				session.save(aux);
				ser.add(aux);
			} else {
				SeientEnRepresentacio aux = new SeientEnRepresentacio(
						it.next(), rep, Estat.ocupat);
				session.save(aux);
				ser.add(aux);
				--ll;
			}
		}
		rep.setNombreSeientsLliures(ll);
		rep.setSeientsEnRepresentacio(ser);
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
