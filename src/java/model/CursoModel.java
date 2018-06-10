/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Curso;
import entity.Profesor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CursoModel {

	// Read
	public List<Curso> getAll() {
		List<Curso> lst = new ArrayList<Curso>();
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			String hql = "from Curso as c inner join c.profesor as p order by c.nombre asc";
			lst = s.createQuery(hql).list();
			// lst = s.createCriteria(Curso.class).list();
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	public void create(Curso p) {
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
	public void remove(Curso p) {
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
	public void edit(Curso p) {
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
	
	public Curso getCurso(int id){
          
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Curso p=new Curso();
        
        try {
			Profesor profe = new Profesor();
			//List<Object> lst = new ArrayList<Object>();
            s.beginTransaction();
			//String hql = "from Curso as c join Profesor as p where c.id=8";
			//String hql = "from Curso as c where c.id=8";
			//Query query = s.createQuery(hql);
			//query.setParameter("id", id);
			//query.setMaxResults(1);
//			List<Object[]> lst = query.list();
//			for (Object[] aRow : lst) {
//				p = (Curso) aRow[0];
//				profe = (Profesor) aRow[1];				
//			}
			//p=(Curso) lst.get(0);						
			
            p=(Curso) s.get(Curso.class,id);
			//p.setProfesor(profe);
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            s.getTransaction().rollback();
        }
          
      
      return p;
      
      }
}
