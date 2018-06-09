/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ProfesorModel {

	// Read
	public List<Profesor> getAll() {
		List<Profesor> lst = new ArrayList<Profesor>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			lst = s.createCriteria(Profesor.class).list();
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	public void create(Profesor p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.save(p);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
	}

	//remove
	public void remove(Profesor p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.delete(p);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
	}

	//update
	public void edit(Profesor p) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.update(p);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
	}
}
