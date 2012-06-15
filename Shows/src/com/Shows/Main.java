package com.Shows;

import java.awt.EventQueue;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Shows.Presentation.Controller.ComprarEntradaController;

public class Main {

	@SuppressWarnings("unused")
	private static ComprarEntradaController comprarEntradaController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/***** init DB *****/
		// DataBaseInitializer.clearDatabase();
		if (need2InitDataBase())
			DataBaseInitializer.initDatabase();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comprarEntradaController = new ComprarEntradaController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean need2InitDataBase() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query = session.createQuery("Select fila from Seient");

		return (query.list().size() == 0);
	}
}
