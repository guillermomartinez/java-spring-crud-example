/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Profesor;
import java.math.BigDecimal;
import java.math.BigInteger;
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
			String hql = "from Profesor as p order by p.nombre asc";
			lst = s.createQuery(hql).list();
			// lst = s.createCriteria(Profesor.class).list();
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
	
	public Profesor getProfesor(int id){
          
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Profesor p=new Profesor();
        
        try {
            s.beginTransaction();
            p=(Profesor) s.get(Profesor.class,id);
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            s.getTransaction().rollback();
        }
          
      
      return p;
      
      }
}
