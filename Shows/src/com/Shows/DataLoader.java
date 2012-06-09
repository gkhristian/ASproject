package com.Shows;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.Shows.Domain.Model.Entrada;
import com.Shows.Domain.Model.Espectacle;
import com.Shows.Domain.Model.Estrena;
import com.Shows.Domain.Model.Local;
import com.Shows.Domain.Model.Representacio;
import com.Shows.Domain.Model.Seient;
import com.Shows.Domain.Model.SeientEnRepresentacio;
import com.Shows.Domain.Model.Sessio;
import com.Shows.Domain.Model.TipusSessio;

public class DataLoader {
	public static void initDatabase() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Seient seient = new Seient(1, 1);
		Seient seient2 = new Seient(1, 2);
		/*
		 * seient.setFila(1); seient.setColumna(1);
		 */

		Set<Seient> seients = new HashSet<Seient>();
		seients.add(seient);

		Local local = new Local("1", seients);
		local.setNom("Prueba");
		local.setAdreca("C/Prueba");

		Sessio sesMati = new Sessio(TipusSessio.mati);

		Date data1 = Date.valueOf("2012-6-30");

		Set<SeientEnRepresentacio> seientsEnRepresentacio = new HashSet<SeientEnRepresentacio>();
		SeientEnRepresentacio ser1 = new SeientEnRepresentacio(seient);
		SeientEnRepresentacio ser2 = new SeientEnRepresentacio(seient2);
		seientsEnRepresentacio.add(ser1);
		seientsEnRepresentacio.add(ser2);

		Estrena estA = new Estrena(sesMati, local, (float) 10000, data1, 2,
				seientsEnRepresentacio, 20);

		Representacio repA = estA.getRepresentacio();

		Set<Entrada> entradas1 = new HashSet<Entrada>();
		Entrada entr1 = new Entrada("1", repA);
		Entrada entr2 = new Entrada("2", repA);
		entradas1.add(entr1);
		entradas1.add(entr2);

		repA.setEntradas(entradas1);

		Espectacle espectacleA = new Espectacle("Espectacular", 3, repA);

		session.save(seient);
		session.save(seient2);
		session.save(local);
		session.save(ser1);
		session.save(ser2);
		session.save(sesMati);
		session.save(repA);
		session.save(entr1);
		session.save(entr2);
		session.save(espectacleA);
		

		session.getTransaction().commit();

		/*
		 * Client expected = new Client("46975089G", "Miguel", "San Román",
		 * "msanromanv@gmail.com"); Client expected2 = new Client("39391628B",
		 * "Josep", "Lopez", "cyph3rfox@gmail.com");
		 * 
		 * Comentari comment = new Comentari(new
		 * ComentariId("Hotel Pastel Manresa", "46975089G", new Date(100)), 10,
		 * "Es un pastel de hotel, pero me encanta!"); Comentari comment2 = new
		 * Comentari(new ComentariId("Hotel Pastel Manresa", "46975089G", new
		 * Date(50)), 0, "Es un pastel de hotel!"); Comentari comment3 = new
		 * Comentari(new ComentariId("Hotel Pastel Manresa", "39391628B", new
		 * Date(50)), 5,
		 * "Es un pastel de hotel, pero sóc de Manresa i li dono un suficient!"
		 * ); Comentari comment4 = new Comentari(new
		 * ComentariId("Hotel Manresa", "39391628B", new Date(50)), 10,
		 * "Bonissim");
		 * 
		 * Poblacio p = new Poblacio("Manresa"); Poblacio p2 = new
		 * Poblacio("Barcelona"); Categoria c = new Categoria("5"); Categoria c2
		 * = new Categoria("3"); Categoria c20 = new Categoria("Tres");
		 * Categoria c30 = new Categoria("Zero"); Hotel h = new
		 * Hotel("Hotel Manresa",
		 * "El millor hotel que podreu trobar a la capital del Bages", "5",
		 * "Manresa"); Hotel h2 = new Hotel("Hotel Pastel Manresa",
		 * "Un hotel per als amants de l'artesania i el menjar casolà", "3",
		 * "Manresa"); Hotel h3 = new Hotel("Hotel Princesa Sofia",
		 * "Hotel ubicat a l'Avinguda Diagonal, d'impecable reputacio i alta qualitat."
		 * , "Tres", "Barcelona"); Hotel h4 = new Hotel("Hotel Pastel Sofia",
		 * "Hotel mes dolent, que intenta imitar l'estètica del Princesa Sofia"
		 * , "Zero", "Barcelona");
		 * 
		 * HabitacioId hId = new HabitacioId("Hotel Manresa", 1); HabitacioId
		 * hId0 = new HabitacioId("Hotel Pastel Manresa", 2); HabitacioId hId0_1
		 * = new HabitacioId("Hotel Manresa", 3); HabitacioId hId0_2 = new
		 * HabitacioId("Hotel Pastel Manresa", 4); HabitacioId hId0_3 = new
		 * HabitacioId("Hotel Manresa", 5); HabitacioId hId0_4 = new
		 * HabitacioId("Hotel Pastel Manresa", 6);
		 * 
		 * TipusHabitacio tipusHab = new TipusHabitacio("Suite", 3,
		 * "descHabitacio"); TipusHabitacio tipusHab2 = new
		 * TipusHabitacio("Standard", 3, "descHabitacio");
		 * 
		 * IPreuStrategy descompte = new PreuAmbDescompte(new
		 * PreuTipusHabitacioId("Hotel Manresa", "Suite"), 100f); IPreuStrategy
		 * descompte2 = new PreuAmbDescompte(new
		 * PreuTipusHabitacioId("Hotel Manresa", "Standard"), 100f);
		 * IPreuStrategy descompte3 = new PreuAmbPercentatge(new
		 * PreuTipusHabitacioId("Hotel Pastel Manresa", "Suite"), 0.5f);
		 * IPreuStrategy descompte4 = new PreuAmbPercentatge(new
		 * PreuTipusHabitacioId("Hotel Pastel Manresa", "Standard"), 0.5f);
		 * IPreuStrategy descompte50 = new PreuAmbPercentatge(new
		 * PreuTipusHabitacioId("Hotel Pastel Sofia", "Suite"), 0.75f);
		 * IPreuStrategy descompte60 = new PreuAmbPercentatge(new
		 * PreuTipusHabitacioId("Hotel Pastel Sofia", "Standard"), 0.9f);
		 * IPreuStrategy senseDescompte = new PreuAmbDescompte(new
		 * PreuTipusHabitacioId("Hotel Princesa Sofia", "Suite"), 0f);
		 * IPreuStrategy senseDescompte20 = new PreuAmbDescompte(new
		 * PreuTipusHabitacioId("Hotel Princesa Sofia", "Standard"), 0f);
		 * 
		 * PreuTipusHabitacio preuTipusHab = new PreuTipusHabitacio(new
		 * PreuTipusHabitacioId("Hotel Manresa", "Suite"), 500f, descompte);
		 * PreuTipusHabitacio preuTipusHab2 = new PreuTipusHabitacio(new
		 * PreuTipusHabitacioId("Hotel Manresa", "Standard"), 300f, descompte2);
		 * PreuTipusHabitacio preuTipusHab3 = new PreuTipusHabitacio(new
		 * PreuTipusHabitacioId("Hotel Pastel Manresa", "Suite"), 400f,
		 * descompte3); PreuTipusHabitacio preuTipusHab4 = new
		 * PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Manresa",
		 * "Standard"), 200f, descompte4); PreuTipusHabitacio preuTipusHab50 =
		 * new PreuTipusHabitacio(new
		 * PreuTipusHabitacioId("Hotel Princesa Sofia", "Suite"), 2000f,
		 * senseDescompte); PreuTipusHabitacio preuTipusHab60 = new
		 * PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Princesa Sofia",
		 * "Standard"), 1400f, senseDescompte20); PreuTipusHabitacio
		 * preuTipusHab70 = new PreuTipusHabitacio(new
		 * PreuTipusHabitacioId("Hotel Pastel Sofia", "Standard"), 1400f,
		 * descompte60); PreuTipusHabitacio preuTipusHab80 = new
		 * PreuTipusHabitacio(new PreuTipusHabitacioId("Hotel Pastel Sofia",
		 * "Suite"), 1600f, descompte50);
		 * 
		 * 
		 * Habitacio hab = new Habitacio(hId, "Suite"); Habitacio hab2 = new
		 * Habitacio(hId0, "Standard"); Habitacio hab30 = new Habitacio(new
		 * HabitacioId("Hotel Princesa Sofia", 100), "Standard"); Habitacio
		 * hab40 = new Habitacio(new HabitacioId("Hotel Princesa Sofia", 200),
		 * "Suite"); Habitacio hab50 = new Habitacio(new
		 * HabitacioId("Hotel Pastel Sofia", 2), "Standard"); Habitacio hab3 =
		 * new Habitacio(hId0_1, "Suite"); Habitacio hab4 = new
		 * Habitacio(hId0_2, "Standard"); Habitacio hab5 = new Habitacio(hId0_3,
		 * "Standard"); Habitacio hab6 = new Habitacio(hId0_4, "Suite");
		 * 
		 * Reserva res = new Reserva("Hotel Manresa", 1, new Date(100), new
		 * Date(100), new Date(101), 500d); Reserva res2 = new
		 * Reserva("Hotel Pastel Manresa", 2, new Date(100), new Date(100), new
		 * Date(101), 150d);
		 * 
		 * session.saveOrUpdate(expected); session.saveOrUpdate(expected2);
		 * session.saveOrUpdate(p); session.saveOrUpdate(p2);
		 * session.saveOrUpdate(c); session.saveOrUpdate(c20);
		 * session.saveOrUpdate(c30); session.saveOrUpdate(c2);
		 * session.saveOrUpdate(h); session.saveOrUpdate(h2);
		 * session.saveOrUpdate(h3); session.saveOrUpdate(h4);
		 * session.saveOrUpdate(comment); session.saveOrUpdate(comment2);
		 * session.saveOrUpdate(comment3); session.saveOrUpdate(comment4);
		 * session.saveOrUpdate(tipusHab); session.saveOrUpdate(tipusHab2);
		 * session.saveOrUpdate(preuTipusHab);
		 * session.saveOrUpdate(preuTipusHab2);
		 * session.saveOrUpdate(preuTipusHab3);
		 * session.saveOrUpdate(preuTipusHab4);
		 * session.saveOrUpdate(preuTipusHab50);
		 * session.saveOrUpdate(preuTipusHab60);
		 * session.saveOrUpdate(preuTipusHab70);
		 * session.saveOrUpdate(preuTipusHab80);
		 * session.saveOrUpdate(descompte); session.saveOrUpdate(descompte2);
		 * session.saveOrUpdate(descompte3); session.saveOrUpdate(descompte4);
		 * session.saveOrUpdate(descompte50); session.saveOrUpdate(descompte60);
		 * session.saveOrUpdate(senseDescompte);
		 * session.saveOrUpdate(senseDescompte20); session.saveOrUpdate(hab);
		 * session.saveOrUpdate(hab2); session.saveOrUpdate(hab30);
		 * session.saveOrUpdate(hab40); session.saveOrUpdate(hab50);
		 * session.saveOrUpdate(hab3); session.saveOrUpdate(hab4);
		 * session.saveOrUpdate(hab5); session.saveOrUpdate(hab6);
		 * session.saveOrUpdate(res); session.saveOrUpdate(res2);
		 */
	}

	public static void clearDatabase() throws HibernateException {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query;
		query = session.createSQLQuery("DROP SCHEMA public CASCADE");
		query.executeUpdate();

		session.getTransaction().commit();
	}
}
