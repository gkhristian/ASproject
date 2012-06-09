package com.Shows;

import java.awt.EventQueue;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Shows.Presentation.MainView;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/***** init DB *****/
		if (need2InitDataBase())
			DataLoader.initDatabase();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView mainView = new MainView();
					mainView.getFrame().setVisible(true);
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
