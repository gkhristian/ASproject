package com.Shows;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Shows.Presentation.Controller.FrontController;

public class Main {

	@SuppressWarnings("unused")
	private static FrontController comprarEntradaController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/***** init DB *****/
		// DataBaseInitializer.clearDatabase();
		if (need2InitDataBase())
			DataBaseInitializer.initDatabase();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
			}
		});

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comprarEntradaController = new FrontController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean need2InitDataBase() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Query query = session.createQuery("Select nom from Local");

		return (query.list().size() == 0);
	}
}
